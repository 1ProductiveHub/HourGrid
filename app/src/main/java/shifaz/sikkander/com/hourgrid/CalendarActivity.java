package shifaz.sikkander.com.hourgrid;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;

import java.text.ParseException;                                                                    // test comment
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {
    private EditText textInputEventName;
    private EditText textInputStartTime;
    private EditText textInputDuration;

    private Button confirm;

    public TextView Duration;

    public DatePicker datePicker;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        textInputEventName = findViewById(R.id.text_input_eventName);
        textInputStartTime = findViewById(R.id.text_input_startTime);
        textInputDuration = findViewById(R.id.text_input_duration);

        confirm = findViewById(R.id.confirm);

        Duration = findViewById(R.id.duration);

        datePicker = findViewById(R.id.datePicker);

        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ++i;
                final String EventName = textInputEventName.getText().toString();
                String startTime = textInputStartTime.getText().toString();
                String durationTime = textInputDuration.getText().toString();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                try {
                    Date date1 = format.parse(startTime);
                    Date date2 = format.parse(durationTime);
                    float minDifference = ((date2.getTime() - date1.getTime()) / 60000);
                    float hourDifference = minDifference / 60;
                    Duration.setText("Day: " + datePicker.getDayOfMonth() + "/" + (datePicker.getMonth()+1) + "/" + datePicker.getYear() + "\n" + hourDifference + " hours");

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(), "Day: "  + datePicker.getDayOfMonth() + "/" + (datePicker.getMonth()+1) + "/" + datePicker.getYear() + "\nEvent Name: " + EventName + "\nStartTime: " + startTime + "\nEndTime: " + durationTime, Toast.LENGTH_SHORT).show();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 1s = 1000ms
                        Intent intentFrameLayoutActivity = new Intent(CalendarActivity.this, FrameLayoutActivity.class);
                        intentFrameLayoutActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                        intentFrameLayoutActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                        intentFrameLayoutActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                        intentFrameLayoutActivity.putExtra ( "TextBox3", i);
                        intentFrameLayoutActivity.putExtra ( "TextBox4", datePicker.getDayOfMonth());
                        intentFrameLayoutActivity.putExtra ( "TextBox5", (datePicker.getMonth()+1));
                        intentFrameLayoutActivity.putExtra ( "TextBox6", datePicker.getYear());
                        intentFrameLayoutActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                        startActivity(intentFrameLayoutActivity);
                    }
                }, 1000);
            }
        });
    }
}
