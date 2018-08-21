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
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    RadioGroup radioGroup;
    RadioButton radioButton, Sa, Su, Mo, Tu, We, Th, Fr;


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

        radioGroup = findViewById(R.id.radioGroup);
        Sa = findViewById(R.id.saturday);
        Su = findViewById(R.id.sunday);
        Mo = findViewById(R.id.monday);
        Tu = findViewById(R.id.tuesday);
        We = findViewById(R.id.wednesday);
        Th = findViewById(R.id.thursday);
        Fr = findViewById(R.id.friday);

        confirm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

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
                    Duration.setText("Day: " + radioButton.getText() + "\n" + hourDifference + " hours");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(), "Day: "+ radioButton.getText() + "\nEvent Name: " + EventName + "\nStartTime: " + startTime + "\nEndTime: " + durationTime, Toast.LENGTH_SHORT).show();

                if(Su.isChecked()){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms
                            Intent intentHourGridSundayActivity = new Intent(MainActivity.this, HourGridSundayActivity.class);
                            intentHourGridSundayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                            intentHourGridSundayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                            intentHourGridSundayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                            intentHourGridSundayActivity.putExtra ( "TextBox3", i);
                            intentHourGridSundayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                            startActivity(intentHourGridSundayActivity);
                        }
                    }, 1000);
                }else if(Mo.isChecked()){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms
                            Intent intentHourGridMondayActivity = new Intent(MainActivity.this, HourGridMondayActivity.class);
                            intentHourGridMondayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                            intentHourGridMondayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                            intentHourGridMondayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                            intentHourGridMondayActivity.putExtra ( "TextBox3", i);
                            intentHourGridMondayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                            startActivity(intentHourGridMondayActivity);
                        }
                    }, 1000);
                }else if(Tu.isChecked()){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms
                            Intent intentHourGridTuesdayActivity = new Intent(MainActivity.this, HourGridTuesdayActivity.class);
                            intentHourGridTuesdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                            intentHourGridTuesdayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                            intentHourGridTuesdayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                            intentHourGridTuesdayActivity.putExtra ( "TextBox3", i);
                            intentHourGridTuesdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                            startActivity(intentHourGridTuesdayActivity);
                        }
                    }, 1000);
                }else if(We.isChecked()){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms
                            Intent intentHourGridWednesdayActivity = new Intent(MainActivity.this, HourGridWednesdayActivity.class);
                            intentHourGridWednesdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                            intentHourGridWednesdayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                            intentHourGridWednesdayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                            intentHourGridWednesdayActivity.putExtra ( "TextBox3", i);
                            intentHourGridWednesdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                            startActivity(intentHourGridWednesdayActivity);
                        }
                    }, 1000);
                }else if(Th.isChecked()){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms
                            Intent intentHourGridThursdayActivity = new Intent(MainActivity.this, HourGridThursdayActivity.class);
                            intentHourGridThursdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                            intentHourGridThursdayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                            intentHourGridThursdayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                            intentHourGridThursdayActivity.putExtra ( "TextBox3", i);
                            intentHourGridThursdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                            startActivity(intentHourGridThursdayActivity);
                        }
                    }, 1000);
                }else if(Fr.isChecked()){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms
                            Intent intentHourGridFridayActivity = new Intent(MainActivity.this, HourGridFridayActivity.class);
                            intentHourGridFridayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                            intentHourGridFridayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                            intentHourGridFridayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                            intentHourGridFridayActivity.putExtra ( "TextBox3", i);
                            intentHourGridFridayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                            startActivity(intentHourGridFridayActivity);
                        }
                    }, 1000);
                }else if(Sa.isChecked()){
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms
                            Intent intentHourGridSaturdayActivity = new Intent(MainActivity.this, HourGridSaturdayActivity.class);
                            intentHourGridSaturdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                            intentHourGridSaturdayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                            intentHourGridSaturdayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                            intentHourGridSaturdayActivity.putExtra ( "TextBox3", i);
                            intentHourGridSaturdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                            startActivity(intentHourGridSaturdayActivity);
                        }
                    }, 1000);
                }
            }
        });
    }
}
