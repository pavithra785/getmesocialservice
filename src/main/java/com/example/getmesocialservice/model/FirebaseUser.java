package com.example.getmesocialservice.model;

public class FirebaseUser {
    private String uid;

    public String getUid() {
        return uid;
    }

    public FirebaseUser(String uid, String name, String email) {
        this.uid = uid;
        this.name = name;
        this.email = email;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    private String name;
    private  String email;
}
