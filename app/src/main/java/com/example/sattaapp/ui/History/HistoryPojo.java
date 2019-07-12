package com.example.sattaapp.ui.History;

public class HistoryPojo {
    private String location;
    private String bid_type;
    private String bid_time;
    private String bid_number;
    private String bid_amount;

    public HistoryPojo(String location, String bid_type, String bid_time, String bid_number, String bid_amount) {
        this.location = location;
        this.bid_type = bid_type;
        this.bid_time = bid_time;
        this.bid_number = bid_number;
        this.bid_amount = bid_amount;
    }

    public String getLocation() {
        return location;
    }

    public String getBid_type() {
        return bid_type;
    }

    public String getBid_time() {
        return bid_time;
    }

    public String getBid_number() {
        return bid_number;
    }

    public String getBid_amount() {
        return bid_amount;
    }
}
