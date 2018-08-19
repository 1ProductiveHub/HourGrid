package shifaz.sikkander.com.hourgrid;

import com.google.gson.annotations.SerializedName;

class EventItem {
    private String eventName;
    private String startTime;
    private String durationTime;

    public EventItem(String eventName, String startTime, String durationTime){
        this.eventName = eventName;
        this.startTime = startTime;
        this.durationTime = durationTime;
    }
}
