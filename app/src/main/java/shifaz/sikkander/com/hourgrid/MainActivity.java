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
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText textInputEventName;
    private EditText textInputStartTime;
    private EditText textInputDuration;

    private Button hourGridSA, hourGridSU, hourGridMO, hourGridTU, hourGridWE, hourGridTH, hourGridFR;
    private Button confirm, calendar;

    private Button toToListBtn;

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

        hourGridSA = findViewById(R.id.hourGridSA);
        hourGridSU = findViewById(R.id.hourGridSU);
        hourGridMO = findViewById(R.id.hourGridMO);
        hourGridTU = findViewById(R.id.hourGridTU);
        hourGridWE = findViewById(R.id.hourGridWE);
        hourGridTH = findViewById(R.id.hourGridTH);
        hourGridFR = findViewById(R.id.hourGridFR);
        confirm = findViewById(R.id.confirm);
        calendar = findViewById(R.id.calendar);

        Duration = findViewById(R.id.duration);

        radioGroup = findViewById(R.id.radioGroup);
        Sa = findViewById(R.id.saturday);
        Su = findViewById(R.id.sunday);
        Mo = findViewById(R.id.monday);
        Tu = findViewById(R.id.tuesday);
        We = findViewById(R.id.wednesday);
        Th = findViewById(R.id.thursday);
        Fr = findViewById(R.id.friday);

        toToListBtn = findViewById(R.id.todobtn);

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

                    if(date2.before(date1)){
                        overNightEvent();
                    }
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

        calendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intentCalendarActivity = new Intent(MainActivity.this, CalendarActivity.class);
//                intentCalendarActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                startActivity(intentCalendarActivity);
            }
        });

        hourGridSA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intentSaturdayActivity = new Intent(MainActivity.this, HourGridSaturdayActivity.class);
                intentSaturdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                intentSaturdayActivity.putExtra ( "TextBox", "");
                intentSaturdayActivity.putExtra ( "TextBox1", "00:00"); //Passing information to HourGridActivity
                intentSaturdayActivity.putExtra ( "TextBox2", "00:00");
                intentSaturdayActivity.putExtra ( "TextBox3", i);
                startActivity(intentSaturdayActivity);
                --i;
            }
        });

        hourGridSU.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intentSundayActivity = new Intent(MainActivity.this, HourGridSundayActivity.class);
                intentSundayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                intentSundayActivity.putExtra ( "TextBox", "");
                intentSundayActivity.putExtra ( "TextBox1", "00:00"); //Passing information to HourGridActivity
                intentSundayActivity.putExtra ( "TextBox2", "00:00");
                intentSundayActivity.putExtra ( "TextBox3", i);
                startActivity(intentSundayActivity);
                --i;
            }
        });

        hourGridMO.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intentMondayActivity = new Intent(MainActivity.this, HourGridMondayActivity.class);
                intentMondayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                intentMondayActivity.putExtra ( "TextBox", "");
                intentMondayActivity.putExtra ( "TextBox1", "00:00"); //Passing information to HourGridActivity
                intentMondayActivity.putExtra ( "TextBox2", "00:00");
                intentMondayActivity.putExtra ( "TextBox3", i);
                startActivity(intentMondayActivity);
                --i;
            }
        });

        hourGridTU.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intentTuesdayActivity = new Intent(MainActivity.this, HourGridTuesdayActivity.class);
                intentTuesdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                intentTuesdayActivity.putExtra ( "TextBox", "");
                intentTuesdayActivity.putExtra ( "TextBox1", "00:00"); //Passing information to HourGridActivity
                intentTuesdayActivity.putExtra ( "TextBox2", "00:00");
                intentTuesdayActivity.putExtra ( "TextBox3", i);
                startActivity(intentTuesdayActivity);
                --i;
            }
        });

        hourGridWE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intentWednesdayActivity = new Intent(MainActivity.this, HourGridWednesdayActivity.class);
                intentWednesdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                intentWednesdayActivity.putExtra ( "TextBox", "");
                intentWednesdayActivity.putExtra ( "TextBox1", "00:00"); //Passing information to HourGridActivity
                intentWednesdayActivity.putExtra ( "TextBox2", "00:00");
                intentWednesdayActivity.putExtra ( "TextBox3", i);
                startActivity(intentWednesdayActivity);
                --i;
            }
        });

        hourGridTH.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intentThursdayActivity = new Intent(MainActivity.this, HourGridThursdayActivity.class);
                intentThursdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                intentThursdayActivity.putExtra ( "TextBox", "");
                intentThursdayActivity.putExtra ( "TextBox1", "00:00"); //Passing information to HourGridActivity
                intentThursdayActivity.putExtra ( "TextBox2", "00:00");
                intentThursdayActivity.putExtra ( "TextBox3", i);
                startActivity(intentThursdayActivity);
                --i;
            }
        });

        hourGridFR.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intentFridayActivity = new Intent(MainActivity.this, HourGridFridayActivity.class);
                intentFridayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                intentFridayActivity.putExtra ( "TextBox", "");
                intentFridayActivity.putExtra ( "TextBox1", "00:00"); //Passing information to HourGridActivity
                intentFridayActivity.putExtra ( "TextBox2", "00:00");
                intentFridayActivity.putExtra ( "TextBox3", i);
                startActivity(intentFridayActivity);
                --i;
            }
        });

        toToListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ToDoList.class);
                startActivity(intent);
            }
        });
    }

    public void overNightEvent (){
        if(Sa.isChecked()){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    Intent intentHourGridSaturdayActivity = new Intent(MainActivity.this, HourGridSaturdayActivity.class);
                    intentHourGridSaturdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                    intentHourGridSaturdayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                    intentHourGridSaturdayActivity.putExtra ( "TextBox2", "24:00");
                    intentHourGridSaturdayActivity.putExtra ( "TextBox3", i);
                    intentHourGridSaturdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                    nextSunday();
                    startActivity(intentHourGridSaturdayActivity);
                }
            }, 1000);
            --i;
        }else if(Su.isChecked()){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    Intent intentHourGridSundayActivity = new Intent(MainActivity.this, HourGridSundayActivity.class);
                    intentHourGridSundayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                    intentHourGridSundayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                    intentHourGridSundayActivity.putExtra ( "TextBox2", "24:00");
                    intentHourGridSundayActivity.putExtra ( "TextBox3", i);
                    intentHourGridSundayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                    nextMonday();
                    startActivity(intentHourGridSundayActivity);
                }
            }, 1000);
            --i;
        }else if(Mo.isChecked()){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    Intent intentHourGridMondayActivity = new Intent(MainActivity.this, HourGridMondayActivity.class);
                    intentHourGridMondayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                    intentHourGridMondayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                    intentHourGridMondayActivity.putExtra ( "TextBox2", "24:00");
                    intentHourGridMondayActivity.putExtra ( "TextBox3", i);
                    intentHourGridMondayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                    nextTuesday();
                    startActivity(intentHourGridMondayActivity);
                }
            }, 1000);
            --i;
        }else if(Tu.isChecked()){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    Intent intentHourGridTuesdayActivity = new Intent(MainActivity.this, HourGridTuesdayActivity.class);
                    intentHourGridTuesdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                    intentHourGridTuesdayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                    intentHourGridTuesdayActivity.putExtra ( "TextBox2", "24:00");
                    intentHourGridTuesdayActivity.putExtra ( "TextBox3", i);
                    intentHourGridTuesdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                    nextWednesday();
                    startActivity(intentHourGridTuesdayActivity);
                }
            }, 1000);
            --i;
        }else if(We.isChecked()){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    Intent intentHourGridWednesdayActivity = new Intent(MainActivity.this, HourGridWednesdayActivity.class);
                    intentHourGridWednesdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                    intentHourGridWednesdayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                    intentHourGridWednesdayActivity.putExtra ( "TextBox2", "24:00");
                    intentHourGridWednesdayActivity.putExtra ( "TextBox3", i);
                    intentHourGridWednesdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                    nextThursday();
                    startActivity(intentHourGridWednesdayActivity);
                }
            }, 1000);
            --i;
        }else if(Th.isChecked()){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    Intent intentHourGridThursdayActivity = new Intent(MainActivity.this, HourGridThursdayActivity.class);
                    intentHourGridThursdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                    intentHourGridThursdayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                    intentHourGridThursdayActivity.putExtra ( "TextBox2", "24:00");
                    intentHourGridThursdayActivity.putExtra ( "TextBox3", i);
                    intentHourGridThursdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                    nextFriday();
                    startActivity(intentHourGridThursdayActivity);
                }
            }, 1000);
            --i;
        }else if(Fr.isChecked()){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    Intent intentHourGridFridayActivity = new Intent(MainActivity.this, HourGridFridayActivity.class);
                    intentHourGridFridayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                    intentHourGridFridayActivity.putExtra ( "TextBox1", textInputStartTime.getText().toString()); //Passing information to HourGridActivity
                    intentHourGridFridayActivity.putExtra ( "TextBox2", "24:00");
                    intentHourGridFridayActivity.putExtra ( "TextBox3", i);
                    intentHourGridFridayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                    nextSaturday();
                    startActivity(intentHourGridFridayActivity);
                }
            }, 1000);
            --i;
        }
    }
    public void nextSunday (){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms
                Intent intentHourGridSundayActivity = new Intent(MainActivity.this, HourGridSundayActivity.class);
                intentHourGridSundayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                intentHourGridSundayActivity.putExtra ( "TextBox1", "0:00"); //Passing information to HourGridActivity
                intentHourGridSundayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                intentHourGridSundayActivity.putExtra ( "TextBox3", i);
                intentHourGridSundayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                startActivity(intentHourGridSundayActivity);
            }
        }, 1000);
        --i;
    }
    public void nextMonday (){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms
                Intent intentHourGridMondayActivity = new Intent(MainActivity.this, HourGridMondayActivity.class);
                intentHourGridMondayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                intentHourGridMondayActivity.putExtra ( "TextBox1", "0:00"); //Passing information to HourGridActivity
                intentHourGridMondayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                intentHourGridMondayActivity.putExtra ( "TextBox3", i);
                intentHourGridMondayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                startActivity(intentHourGridMondayActivity);
            }
        }, 1000);
        --i;
    }
    public void nextTuesday (){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms
                Intent intentHourGridTuesdayActivity = new Intent(MainActivity.this, HourGridTuesdayActivity.class);
                intentHourGridTuesdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                intentHourGridTuesdayActivity.putExtra ( "TextBox1", "0:00"); //Passing information to HourGridActivity
                intentHourGridTuesdayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                intentHourGridTuesdayActivity.putExtra ( "TextBox3", i);
                intentHourGridTuesdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                startActivity(intentHourGridTuesdayActivity);
            }
        }, 1000);
        --i;
    }
    public void nextWednesday (){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms
                Intent intentHourGridWednesdayActivity = new Intent(MainActivity.this, HourGridWednesdayActivity.class);
                intentHourGridWednesdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                intentHourGridWednesdayActivity.putExtra ( "TextBox1", "0:00"); //Passing information to HourGridActivity
                intentHourGridWednesdayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                intentHourGridWednesdayActivity.putExtra ( "TextBox3", i);
                intentHourGridWednesdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                startActivity(intentHourGridWednesdayActivity);
            }
        }, 1000);
        --i;
    }
    public void nextThursday (){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms
                Intent intentHourGridThursdayActivity = new Intent(MainActivity.this, HourGridThursdayActivity.class);
                intentHourGridThursdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                intentHourGridThursdayActivity.putExtra ( "TextBox1", "0:00"); //Passing information to HourGridActivity
                intentHourGridThursdayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                intentHourGridThursdayActivity.putExtra ( "TextBox3", i);
                intentHourGridThursdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                startActivity(intentHourGridThursdayActivity);
            }
        }, 1000);
        --i;
    }
    public void nextFriday (){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms
                Intent intentHourGridFridayActivity = new Intent(MainActivity.this, HourGridFridayActivity.class);
                intentHourGridFridayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                intentHourGridFridayActivity.putExtra ( "TextBox1", "0:00"); //Passing information to HourGridActivity
                intentHourGridFridayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                intentHourGridFridayActivity.putExtra ( "TextBox3", i);
                intentHourGridFridayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                startActivity(intentHourGridFridayActivity);
            }
        }, 1000);
        --i;
    }
    public void nextSaturday (){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms
                Intent intentHourGridSaturdayActivity = new Intent(MainActivity.this, HourGridSaturdayActivity.class);
                intentHourGridSaturdayActivity.putExtra ( "TextBox", textInputEventName.getText().toString());
                intentHourGridSaturdayActivity.putExtra ( "TextBox1", "0:00"); //Passing information to HourGridActivity
                intentHourGridSaturdayActivity.putExtra ( "TextBox2", textInputDuration.getText().toString());
                intentHourGridSaturdayActivity.putExtra ( "TextBox3", i);
                intentHourGridSaturdayActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); //To prevent information being refreshed
                startActivity(intentHourGridSaturdayActivity);
            }
        }, 1000);
        --i;
    }
}