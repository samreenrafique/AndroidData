package com.example.myapplication;

public class UserInfo {
    String name,email,password,Country;

    UserInfo(){

    }

    public UserInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserInfo(String name, String email, String password, String country) {
        this.name = name;
        this.email = email;
        this.password = password;
        Country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
