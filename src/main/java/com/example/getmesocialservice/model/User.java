package com.example.getmesocialservice.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;
    private String name;
    private String address;
    private String email;
    private String profilePhotoUrl;

    public User(String name, String email, String profilePhotoUrl) {
        this.name = name;
        this.email = email;
        this.profilePhotoUrl = profilePhotoUrl;
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

    public String getAddress() { return address;}
    public void setAddress(String address) {this.address = address;}
    public String getprofilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setprofilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }


//    private int age;

//    public int getAge() {return age;}
//    public void setAge(int age) {this.age = age;}

}
