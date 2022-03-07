package com.art.merumuseum.GuideModules.guide;

public class guideobject {

    String amount;
    String date;
    String email;
    String status;
    String id;

    public guideobject(String amount, String date, String email, String status, String id) {
        this.amount = amount;
        this.date = date;
        this.email = email;
        this.status = status;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
