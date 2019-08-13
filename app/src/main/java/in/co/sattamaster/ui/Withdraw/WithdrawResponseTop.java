package in.co.sattamaster.ui.Withdraw;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WithdrawResponseTop {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private WithdrawResponse data;

    public Boolean getStatus() {
        return status;
    }

    public WithdrawResponse getData() {
        return data;
    }
}
