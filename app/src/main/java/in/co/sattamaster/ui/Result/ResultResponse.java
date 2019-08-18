package in.co.sattamaster.ui.Result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import in.co.sattamaster.ui.Homepage.LocationPojo;

public class ResultResponse {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("centre_id")
    @Expose
    private String centreId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("created_at_time")
    @Expose
    private String createdAtTime;
    @SerializedName("centre")
    @Expose
    private LocationPojo centre;

    public String getId() {
        return id;
    }

    public String getCentreId() {
        return centreId;
    }

    public String getNumber() {
        return number;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCreatedAtTime() {
        return createdAtTime;
    }

    public LocationPojo getCentre() {
        return centre;
    }
}
