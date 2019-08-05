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

    public String getAddress() {
        return address;
    }

    public String getCoinBalance() {
        return coinBalance;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
