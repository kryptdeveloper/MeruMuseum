package com.art.merumuseum.LearnModules.modelEvents;

public class EventObject {
    String title;
    String des;
    String date;

    public EventObject(String title, String des,String date) {
        this.title = title;
        this.des = des;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
