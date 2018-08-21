package shifaz.sikkander.com.hourgrid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HourGridWednesdayActivity extends AppCompatActivity {
    private TextView inputEventName;
    private TextView inputStartTime;
    private TextView inputDuration;

    private RelativeLayout layout;

    public static ArrayList<String> arrayEventNameWE = new ArrayList<String>();
    public static ArrayList<String> arrayStartTimeWE = new ArrayList<String>();
    public static ArrayList<String> arrayDurationTimeWE = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hour_grid);

        inputEventName = findViewById(R.id.input_eventName);
        inputStartTime = findViewById(R.id.input_startTime);
        inputDuration = findViewById(R.id.input_duration);

        Intent getEventName = getIntent();
        String eventName = getEventName.getStringExtra ( "TextBox");
        Intent getStartTime = getIntent();
        String startTime = getStartTime.getStringExtra ( "TextBox1");
        Intent getDurationTime = getIntent();
        String durationTime = getDurationTime.getStringExtra ( "TextBox2");

        Intent getCounter = getIntent();
        int counter = getCounter.getIntExtra ("TextBox3", 0);

        inputEventName.setText(eventName);
        inputStartTime.setText(startTime);
        inputDuration.setText(durationTime);
        String midNight = "00:00";

        arrayEventNameWE.add(eventName);
        arrayStartTimeWE.add(startTime);
        arrayDurationTimeWE.add(durationTime);

        for (int i = 0; i < (arrayEventNameWE.size()); i++){
            startTime = arrayStartTimeWE.get(i);
            durationTime = arrayDurationTimeWE.get(i);

            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            try {
                Date date1 = format.parse(startTime);
                Date date2 = format.parse(durationTime);
                Date date3 = format.parse(midNight);
                float minDifference = ((date2.getTime() - date1.getTime())/60000);
                float hourDifference = minDifference/60;
                inputDuration.setText(hourDifference + " hours ");

                float minStarting = ((date1.getTime() - date3.getTime())/60000);
                float hourStarting = minStarting/60;
                inputStartTime.setText(hourStarting + " Starts ");

                float height = 26 * hourDifference;
                float starting = 16 + (26 * hourStarting);

                TextView secondText = new TextView(HourGridWednesdayActivity.this);
                layout = findViewById(R.id.layout);
                Resources r = layout.getResources();
                int pxLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 75, r.getDisplayMetrics());
                int pxTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, starting, r.getDisplayMetrics());
                int pxHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, r.getDisplayMetrics());
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, pxHeight);

                params.setMargins(pxLeft,pxTop,0,0);
                secondText.setText(arrayEventNameWE.get(i));
                int[] opaqueColours = HourGridWednesdayActivity.this.getResources().getIntArray(R.array.opaqueColours);
                secondText.setBackgroundColor(opaqueColours[i]);
                if (i > 10){
                    secondText.setBackgroundResource(R.color.pink);
                }
                if (hourDifference <= 0.5){
                    secondText.setTextSize(9);
                }else {
                    secondText.setTextSize(16);
                }
                secondText.setId(i);

                layout.addView(secondText, params);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}