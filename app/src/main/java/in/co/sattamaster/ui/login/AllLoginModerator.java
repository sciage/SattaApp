package in.co.sattamaster.ui.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllLoginModerator {
    @SerializedName("moderator_id")
    @Expose
    private String moderatorId;
    @SerializedName("coin_balance")
    @Expose
    private String coinBalance;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("moderator")
    @Expose
    private AllModerators moderator;

    public String getModeratorId() {
        return moderatorId;
    }

    public String getCoinBalance() {
        return coinBalance;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public AllModerators getModerator() {
        return moderator;
    }
}
