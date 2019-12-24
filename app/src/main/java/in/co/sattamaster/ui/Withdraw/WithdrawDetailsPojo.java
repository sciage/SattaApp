package in.co.sattamaster.ui.Withdraw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WithdrawDetailsPojo {
    @SerializedName("current_page")
    @Expose
    private String currentPage;
    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("first_page_url")
    @Expose
    private String firstPageUrl;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("last_page")
    @Expose
    private String lastPage;
    @SerializedName("last_page_url")
    @Expose
    private String lastPageUrl;
    @SerializedName("next_page_url")
    @Expose
    private String nextPageUrl;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("per_page")
    @Expose
    private String perPage;
    @SerializedName("prev_page_url")
    @Expose
    private String prevPageUrl;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("total")
    @Expose
    private String total;


    public String getCurrentPage() {
        return currentPage;
    }

    public List<Data> getData() {
        return data;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public String getFrom() {
        return from;
    }

    public String getLastPage() {
        return lastPage;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public String getPerPage() {
        return perPage;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public String getTo() {
        return to;
    }

    public String getTotal() {
        return total;
    }

    public class Data{

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("player_id")
        @Expose
        private Integer playerId;
        @SerializedName("amount")
        @Expose
        private Integer amount;
        @SerializedName("is_completed")
        @Expose
        private Boolean isCompleted;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getId() {
            return id;
        }

        public Integer getPlayerId() {
            return playerId;
        }

        public Integer getAmount() {
            return amount;
        }

        public Boolean getCompleted() {
            return isCompleted;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }
    }
}
