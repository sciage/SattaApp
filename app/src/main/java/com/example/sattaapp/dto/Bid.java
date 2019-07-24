package com.example.sattaapp.dto;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class Bid {
    String type;
    Map<String, String> bid;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getBid() {
        return bid;
    }

    public void setBid(Map<String, String> bid) {
        this.bid = bid;
    }
}
