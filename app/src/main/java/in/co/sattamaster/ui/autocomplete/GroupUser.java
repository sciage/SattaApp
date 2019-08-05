package in.co.sattamaster.ui.autocomplete;

public class GroupUser {

    private String group_id;
    private String name;
    private String category;
    private String id_categories;

    public GroupUser(String group_id, String name, String category) {
        this.group_id = group_id;
        this.name = name;
        this.category = category;
    }

    public String getId_categories() {
        return id_categories;
    }

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
