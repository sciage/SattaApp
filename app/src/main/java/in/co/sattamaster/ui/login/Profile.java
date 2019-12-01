package in.co.sattamaster.ui.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("coin_balance")
    @Expose
    private String coinBalance;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("jodi_bid_max_length")
    @Expose
    private int jodi_bid_max_length;

    public String getAddress() {
        return address;
    }

    public String getCoinBalance() {
        return coinBalance;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public int getJodi_bid_max_length() {
        return jodi_bid_max_length;
    }
}
