package com.art.merumuseum.Finance.Fmodels;

public class PayObject {
    String amount;
    String name;
    String fname;
    String sname;

    String mpesacode;
    String date;
    String transid;
    String status;
    String comp;

    public PayObject(String amount, String name, String fname, String sname, String mpesacode, String date, String transid, String status, String comp) {
        this.amount = amount;
        this.name = name;
        this.fname = fname;
        this.sname = sname;
        this.mpesacode = mpesacode;
        this.date = date;
        this.transid = transid;
        this.status = status;
        this.comp = comp;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMpesacode() {
        return mpesacode;
    }

    public void setMpesacode(String mpesacode) {
        this.mpesacode = mpesacode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
