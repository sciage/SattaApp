package in.co.sattamaster.ui.autocomplete;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupAll {

    @SerializedName("group_id") @Expose private String group_id;
    @SerializedName("group_name") @Expose private String name;
    @SerializedName("category") @Expose private String category;

    public String getGroup_id() {
        return group_id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
