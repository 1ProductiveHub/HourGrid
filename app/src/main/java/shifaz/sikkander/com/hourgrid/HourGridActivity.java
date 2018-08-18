package shifaz.sikkander.com.hourgrid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HourGridActivity extends AppCompatActivity {

    private TextView inputEventName;
    private TextView inputStartTime;
    private TextView inputDuration;

    private RelativeLayout layout;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hour_grid);

        inputEventName = findViewById(R.id.input_eventName);
        inputStartTime = findViewById(R.id.input_startTime);
        inputDuration = findViewById(R.id.input_duration);

        layout = findViewById(R.id.layout);

        Intent getEventName = getIntent();
        String eventName = getEventName.getStringExtra ( "TextBox");
        Intent getStartTime = getIntent();
        String startTime = getStartTime.getStringExtra ( "TextBox1");
        Intent getDurationTime = getIntent();
        String durationTime = getDurationTime.getStringExtra ( "TextBox2");
        inputEventName.setText(eventName);
        inputStartTime.setText(startTime);
        inputDuration.setText(durationTime);

        final Button secondBtn = new Button(HourGridActivity.this);

//        int width = 890;
//        int height = 360;

        float width = 890;
        float height = 90;        // 1 hour ~ 45

        int width_px = (int)convertDpToPixel(width);
        int height_px = (int)convertDpToPixel(height);
//
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
//        secondBtn.setLayoutParams(params);


//        float pixels =  26 * getApplicationContext().getResources().getDisplayMetrics().density;

//        float fPixelsH = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 128, getResources().getDisplayMetrics());
//        int height = (int) (pixels);

//        secondBtn.setWidth(500);
//        secondBtn.setHeight(900);
//        RelativeLayout.LayoutParams myParams = new RelativeLayout.LayoutParams(width, height);
        RelativeLayout.LayoutParams myParams = new RelativeLayout.LayoutParams(width_px, height_px);
//        secondBtn.setTextSize(60);
        secondBtn.setMinHeight(0);
        secondBtn.setMinimumHeight(0);
        secondBtn.setLayoutParams(myParams);

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


        layout.addView(secondBtn, myParams);

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = secondBtn.getHeight();
                String x_str = Integer.toString(x);
                Toast.makeText(HourGridActivity.this, "Height = " + x_str, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public static float convertDpToPixel(float dp){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }
}
