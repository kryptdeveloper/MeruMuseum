package com.art.merumuseum.UserInfo;

public  class Model {
    private  String email="";

    public Model() {
    }

    public Model(String email) {
        this.email = email;
    }

    public  String getEmail() {
        return email;
    }

    public  void setEmail(String email) {
        this.email = email;
    }
}
