package com.example.loginsignup;

public class Register {

    int id;
    String Uname, UEmail;

    public Register(int id, String uname, String UEmail) {
        this.id = id;
        Uname = uname;
        this.UEmail = UEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUEmail() {
        return UEmail;
    }

    public void setUEmail(String UEmail) {
        this.UEmail = UEmail;
    }
}
