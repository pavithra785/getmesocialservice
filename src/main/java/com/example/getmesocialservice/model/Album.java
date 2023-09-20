package com.example.getmesocialservice.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Album {
    @Id
    private int id;
    private String name;
    private String description;
    private String coverPicUrl;
    private Date dateCreated;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl;
    }



}
