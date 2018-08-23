package shifaz.sikkander.com.hourgrid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FrameLayoutActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        Intent getEventName = getIntent();
        String eventName = getEventName.getStringExtra ( "TextBox");
        Intent getStartTime = getIntent();
        String startTime = getStartTime.getStringExtra ( "TextBox1");
        Intent getDurationTime = getIntent();
        String durationTime = getDurationTime.getStringExtra ( "TextBox2");
        Intent getCounter = getIntent();
        int counter = getCounter.getIntExtra ("TextBox3", 0);
        Intent getDayOfMonth = getIntent();
        int dayOfMonth = getDayOfMonth.getIntExtra ( "TextBox4", 0);
        Intent getMonth = getIntent();
        int month = getMonth.getIntExtra ( "TextBox5", 0);
        Intent getYear = getIntent();
        int year = getYear.getIntExtra ( "TextBox6", 0);

        DayFragment fragment = DayFragment.daySelected(dayOfMonth, month, year, eventName, startTime, durationTime, counter);

//        DayFragment fragment = new DayFragment();
//        Bundle args = new Bundle();
//        args.putInt("argDayOfMonth", dayOfMonth);
//        args.putInt("argMonth", month);
//        args.putInt("argYear", year);
//        fragment.setArguments(args);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
