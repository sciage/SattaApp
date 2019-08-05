package in.co.sattamaster.ui.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user")
    @Expose
    private UserProfile user;

    public String getToken() {
        return token;
    }

    public UserProfile getUser() {
        return user;
    }
}

