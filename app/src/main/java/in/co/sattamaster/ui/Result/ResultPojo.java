package in.co.sattamaster.ui.Result;

public class ResultPojo {
    private String date_id;
    private String id_desawar;
    private String id_faridabad;
    private String id_gaziabad;
    private String id_gali;
    private String id_rewari;

    public ResultPojo(String date_id, String id_desawar, String id_faridabad, String id_gaziabad, String id_gali, String id_rewari) {
        this.date_id = date_id;
        this.id_desawar = id_desawar;
        this.id_faridabad = id_faridabad;
        this.id_gaziabad = id_gaziabad;
        this.id_gali = id_gali;
        this.id_rewari = id_rewari;
    }

    public String getId_gali() {
        return id_gali;
    }

    public String getId_rewari() {
        return id_rewari;
    }

    public String getDate_id() {
        return date_id;
    }


    public String getId_desawar() {
        return id_desawar;
    }


    public String getId_faridabad() {
        return id_faridabad;
    }


    public String getId_gaziabad() {
        return id_gaziabad;
    }
}
