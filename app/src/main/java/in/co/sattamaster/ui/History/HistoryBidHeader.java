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
    private String didWin;
    @SerializedName("is_winning_processed")
    @Expose
    private String isWinningProcessed;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("revealed_number_id")
    @Expose
    private String revealedNumberId;
    @SerializedName("coin_balance_cost")
    @Expose
    private String coinBalanceCost;
    @SerializedName("winning_amount")
    @Expose
    private String winningAmount;
    @SerializedName("centre")
    @Expose
    private Centre centre;
    @SerializedName("bidset")
    @Expose
    private Bidset bidset;
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

    public String getDidWin() {
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

    public String getIsWinningProcessed() {
        return isWinningProcessed;
    }

    public String getRevealedNumberId() {
        return revealedNumberId;
    }

    public String getWinningAmount() {
        return winningAmount;
    }

    public Centre getCentre() {
        return centre;
    }

    public Bidset getBidset() {
        return bidset;
    }

    public List<HistoryBidData> getData() {
        return data;
    }

    public class Bidset {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("centre_id")
        @Expose
        private String centre_id;
        @SerializedName("user_id")
        @Expose
        private String user_id;
        @SerializedName("bid_date")
        @Expose
        private String bid_date;
        @SerializedName("bid_hour")
        @Expose
        private String bid_hour;
        @SerializedName("created_at")
        @Expose
        private String created_at;
        @SerializedName("updated_at")
        @Expose
        private String updated_at;
        @SerializedName("coin_balance_cost")
        @Expose
        private String coin_balance_cost;
        @SerializedName("centre_name")
        @Expose
        private String centre_name;
        @SerializedName("centre")
        @Expose
        private Centre centre;


        public String getId() {
            return id;
        }

        public String getCentre_id() {
            return centre_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public String getBid_date() {
            return bid_date;
        }

        public String getBid_hour() {
            return bid_hour;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public String getCoin_balance_cost() {
            return coin_balance_cost;
        }

        public String getCentre_name() {
            return centre_name;
        }

        public Centre getCentre() {
            return centre;
        }
    }

    public class Centre{
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("number_reveal_time")
        @Expose
        private String number_reveal_time;
        @SerializedName("last_bid_time")
        @Expose
        private String last_bid_time;
        @SerializedName("is_hourly")
        @Expose
        private boolean is_hourly;
        @SerializedName("number_last")
        @Expose
        private String number_last;
        @SerializedName("number_current")
        @Expose
        private String number_current;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getNumber_reveal_time() {
            return number_reveal_time;
        }

        public String getLast_bid_time() {
            return last_bid_time;
        }

        public boolean isIs_hourly() {
            return is_hourly;
        }

        public String getNumber_last() {
            return number_last;
        }

        public String getNumber_current() {
            return number_current;
        }
    }
}
