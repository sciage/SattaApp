package in.co.sattamaster.ui.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("data")
    @Expose
    private UserProfile data;

    public Boolean getStatus() {
        return status;
    }

    public UserProfile getData() {
        return data;
    }
}
