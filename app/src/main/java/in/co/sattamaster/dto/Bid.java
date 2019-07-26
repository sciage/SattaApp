package in.co.sattamaster.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Bid {

    @SerializedName("status") @Expose private Boolean status;
    @SerializedName("data") @Expose private Data data;

    public Boolean getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }
}
