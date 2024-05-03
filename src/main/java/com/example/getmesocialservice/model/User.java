package com.example.getmesocialservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class User {

    @Id
    private String id;
    private String name;

    @Email
    private String email;



    public User(String id,String name, String email) {
        this.name = name;
        this.email = email;
        this.id= id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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




}
