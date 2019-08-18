package in.co.sattamaster.ui.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryBidData {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("bid_id")
    @Expose
    private String bidId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getBidId() {
        return bidId;
    }

    public String getNumber() {
        return number;
    }

    public String getAmount() {
        return amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
