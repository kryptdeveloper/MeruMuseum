package com.art.merumuseum.modules.paymentVr;

public class VrPayObject {
    String amount;
    String date;
    String email;
    String status;

    public VrPayObject(String amount, String date, String email, String status) {
        this.amount = amount;
        this.date = date;
        this.email = email;
        this.status = status;
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
