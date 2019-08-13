package in.co.sattamaster.ui.Withdraw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WithdrawResponse {

    @SerializedName("player_id") @Expose private String playerId;
    @SerializedName("amount") @Expose private String amount;
    @SerializedName("updated_at") @Expose private String updatedAt;
    @SerializedName("created_at") @Expose private String createdAt;
    @SerializedName("id") @Expose private String id;

    public String getPlayerId() {
        return playerId;
    }

    public String getAmount() {
        return amount;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }
}
