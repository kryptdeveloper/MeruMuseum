package com.art.merumuseum.GuideModules.guide;

import android.telephony.mbms.StreamingServiceInfo;

public class guideobject {
    String id;
    String fname;
    String sname;
    String amount;
    String getFname;
    String date;
    String mpesacode;

    String status;
    String comp;

    public guideobject(String id, String fname, String sname, String amount, String getFname, String date, String mpesacode, String status, String comp) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.amount = amount;
        this.getFname = getFname;
        this.date = date;
        this.mpesacode = mpesacode;
        this.status = status;
        this.comp = comp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGetFname() {
        return getFname;
    }

    public void setGetFname(String getFname) {
        this.getFname = getFname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMpesacode() {
        return mpesacode;
    }

    public void setMpesacode(String mpesacode) {
        this.mpesacode = mpesacode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }
}
