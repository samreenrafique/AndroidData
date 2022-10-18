package com.example.sql_lite_table;


public class Registrationdata {
    String Id;
    String Username;
    String Email;
    String Password;

    public Registrationdata(String id, String username, String email) {
        Id = id;
        Username = username;
        Email = email;
    }
    public Registrationdata(String id, String username, String email, String password) {
        Id = id;
        Username = username;
        Email = email;
        Password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
