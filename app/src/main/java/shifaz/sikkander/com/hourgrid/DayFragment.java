package shifaz.sikkander.com.hourgrid;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DayFragment extends Fragment {
    private static final String ARG_DOM = "argDayOfMonth";
    private static final String ARG_Month = "argMonth";
    private static final String ARG_Year= "argYear";
    private static final String ARG_EventName= "argEventName";
    private static final String ARG_StartTime= "argStartTime";
    private static final String ARG_DurationTime= "argDurationTime";
    private static final String ARG_Counter= "argCounter";

    private RelativeLayout layout;

    public static ArrayList<String> arrayEventName = new ArrayList<String>();
    public static ArrayList<String> arrayStartTime = new ArrayList<String>();
    public static ArrayList<String> arrayDurationTime = new ArrayList<String>();
    public static ArrayList<Integer> arrayDOM = new ArrayList<Integer>();

    private int DOM, Month, Year, counter;
    private String eventName, startTime, durationTime;

    public static DayFragment daySelected(int DOM, int Month, int Year, String eventName, String startTime, String durationTime, int counter){
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DOM, DOM);
        args.putInt(ARG_Month, Month);
        args.putInt(ARG_Year, Year);
        args.putString(ARG_EventName, eventName);
        args.putString(ARG_StartTime, startTime);
        args.putString(ARG_DurationTime, durationTime);
        args.putInt(ARG_Counter, counter);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_hour_grid, container, false);
        TextView mDay = v.findViewById(R.id.day);
        TextView inputEventName = v.findViewById(R.id.input_eventName);
        TextView inputStartTime = v.findViewById(R.id.input_startTime);
        TextView inputDuration = v.findViewById(R.id.input_duration);

        if (getArguments() != null){
            DOM = getArguments().getInt(ARG_DOM);
            Month = getArguments().getInt(ARG_Month);
            Year = getArguments().getInt(ARG_Year);
            eventName = getArguments().getString(ARG_EventName);
            startTime = getArguments().getString(ARG_StartTime);
            durationTime = getArguments().getString(ARG_DurationTime);
            counter = getArguments().getInt(ARG_Counter);
        }

        mDay.setText(DOM + "/" + Month + "/" + Year);
        inputEventName.setText(eventName);
        inputStartTime.setText(startTime);
        inputDuration.setText(durationTime);
        String midNight = "00:00";

        arrayEventName.add(eventName);
        arrayStartTime.add(startTime);
        arrayDurationTime.add(durationTime);
        arrayDOM.add(DOM);

//        for (int i = 0; i < (arrayDOM.size()); i++){
//            if (arrayDurationTime.get(i) != String.valueOf(DOM))
//            {
//                DayFragment nextFrag= new DayFragment();
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.HourGridActivity, nextFrag,null).addToBackStack(null).commit();
//            }
//        }

        for (int i = 0; i < (arrayEventName.size()); i++){
            startTime = arrayStartTime.get(i);
            durationTime = arrayDurationTime.get(i);

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

                TextView secondText = new TextView(getActivity());
                layout = v.findViewById(R.id.layout);
                Resources r = layout.getResources();
                int pxLeft = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 75, r.getDisplayMetrics());
                int pxTop = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, starting, r.getDisplayMetrics());
                int pxHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, r.getDisplayMetrics());
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, pxHeight);

                params.setMargins(pxLeft,pxTop,0,0);
                secondText.setText(arrayEventName.get(i));
                int[] opaqueColours = getActivity().getResources().getIntArray(R.array.opaqueColours);
                if (i < 10){
                    secondText.setBackgroundColor(opaqueColours[i]);
                }else{
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

        return v;
    }
}
