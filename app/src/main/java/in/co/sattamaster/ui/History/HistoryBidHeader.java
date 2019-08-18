package in.co.sattamaster.ui.History;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryBidHeader {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("bidset_id")
    @Expose
    private String bidsetId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("did_win")
    @Expose
    private Object didWin;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("coin_balance_cost")
    @Expose
    private String coinBalanceCost;
    @SerializedName("data")
    @Expose
    private List<HistoryBidData> data = null;

    public String getId() {
        return id;
    }

    public String getBidsetId() {
        return bidsetId;
    }

    public String getType() {
        return type;
    }

    public Object getDidWin() {
        return didWin;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCoinBalanceCost() {
        return coinBalanceCost;
    }

    public List<HistoryBidData> getData() {
        return data;
    }
}
