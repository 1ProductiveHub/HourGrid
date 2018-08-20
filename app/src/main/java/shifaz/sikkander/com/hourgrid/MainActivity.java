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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;

import java.text.ParseException;                                                                    // test comment
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText textInputEventName;
    private EditText textInputStartTime;
    private EditText textInputDuration;

    private Button hourGrid;
    private Button confirm;

    public TextView Duration;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEventName = findViewById(R.id.text_input_eventName);
        textInputStartTime = findViewById(R.id.text_input_startTime);
        textInputDuration = findViewById(R.id.text_input_duration);

        hourGrid = findViewById(R.id.hourGrid);
        confirm = findViewById(R.id.confirm);

        Duration = findViewById(R.id.duration);

        confirm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                ++i;
                final String EventName = textInputEventName.getText().toString();
                String startTime = textInputStartTime.getText().toString();
                String durationTime = textInputDuration.getText().toString();
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                try {
                    Date date1 = format.parse(startTime);
                    Date date2 = format.parse(durationTime);
                    float minDifference = ((date2.getTime() - date1.getTime())/60000);
                    float hourDifference = minDifference/60;
                    Duration.setText(hourDifference + " hours");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(), "Event Name: " + EventName + "\nStartTime: " + startTime + "\nDuration: " + durationTime + " hours", Toast.LENGTH_SHORT).show();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 1s = 1000ms
                        Intent intentHourGridActivity = new Intent(MainActivity.this, HourGridActivity.class);
                        intentHourGridActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                        intentHourGridActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                        intentHourGridActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                        intentHourGridActivity.putExtra ( "TextBox3", i);
                        intentHourGridActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                        startActivity(intentHourGridActivity);
                    }
                }, 1000);
            }
        });
    }
}
