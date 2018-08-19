package shifaz.sikkander.com.hourgrid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

public class HourGridActivity extends AppCompatActivity {

    // GSon
//    ArrayList<EventItem> mEventList;

    private TextView inputEventName;
    private TextView inputStartTime;
    private TextView inputDuration;

    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hour_grid);

        // GSon
//        loadData();

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

//        final Button secondBtn = new Button(HourGridActivity.this);

//        int width = 890;
//        int height = 360;

//
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
//        secondBtn.setLayoutParams(params);


//        float pixels =  26 * getApplicationContext().getResources().getDisplayMetrics().density;

//        float fPixelsH = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 128, getResources().getDisplayMetrics());
//        int height = (int) (pixels);

//        secondBtn.setWidth(500);
//        secondBtn.setHeight(900);
//        RelativeLayout.LayoutParams myParams = new RelativeLayout.LayoutParams(width, height);
//        RelativeLayout.LayoutParams myParams = new RelativeLayout.LayoutParams(width, height);
//        secondBtn.setTextSize(60);
//        secondBtn.setMinHeight(0);
//        secondBtn.setMinimumHeight(0);
//        secondBtn.setLayoutParams(myParams);

//        float fPixelsX = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 71, getResources().getDisplayMetrics());
//        int pixelsX = (int) (fPixelsX);
//
//        float fPixelsY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 9, getResources().getDisplayMetrics());
//        int pixelsY = (int) (fPixelsY);
//
//
//        secondBtn.setText(eventName);
//        secondBtn.setX(pixelsX);
//        secondBtn.setY(pixelsY);
//        secondBtn.setPadding(0,0,0,0);

//        layout.addView(secondBtn, myParams);

        for (int i = counter; i < (counter + 1); i++){

            SimpleDateFormat format = new SimpleDateFormat("hh:mm");
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
                float starting = 15 + (26 * hourStarting);

                TextView secondText = new TextView(HourGridActivity.this);
                layout = findViewById(R.id.layout);
                Resources r = layout.getResources();
                int pxLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 75, r.getDisplayMetrics());
                int pxTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, starting, r.getDisplayMetrics());
                int pxHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, r.getDisplayMetrics());
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, pxHeight);

                params.setMargins(pxLeft,pxTop,0,0);
                secondText.setText(eventName);
                secondText.setBackgroundResource(R.color.pink);
                secondText.setId(i);

                layout.addView(secondText, params);

                //GSon
//                saveData();

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    //GSon
//    private void saveData(){
//        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(mEventList);
//        editor.putString("task list", json);
//        editor.apply ();
//    }

    //GSon
//    private void loadData(){
//        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPreferences.getString("task list", null);
//        Type type = new TypeToken<ArrayList<EventItem>>() {}.getType();
//        mEventList = gson.fromJson(json, type);
//
//        if (mEventList == null){
//            mEventList = new ArrayList<>();
//        }
//    }
}
