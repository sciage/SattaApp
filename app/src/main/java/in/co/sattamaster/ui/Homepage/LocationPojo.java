package in.co.sattamaster.ui.Homepage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationPojo {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number_reveal_time")
    @Expose
    private String numberRevealTime;
    @SerializedName("last_bid_time")
    @Expose
    private String lastBidTime;
    @SerializedName("is_hourly")
    @Expose
    private Boolean isHourly;
    @SerializedName("number_last")
    @Expose
    private String numberLast;
    @SerializedName("number_current")
    @Expose
    private String numberCurrent;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumberRevealTime() {
        return numberRevealTime;
    }

    public String getLastBidTime() {
        return lastBidTime;
    }

    public Boolean getHourly() {
        return isHourly;
    }

    public String getNumberLast() {
        return numberLast;
    }

    public String getNumberCurrent() {
        return numberCurrent;
    }
}
