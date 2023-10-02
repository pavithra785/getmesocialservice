package com.example.getmesocialservice.model;

import com.example.getmesocialservice.validation.ValidName;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Album {
    @Id
    private String id;

    public Album(String name, String createdBy, String coverPhotoUrl, Date dateCreated) {
        this.name = name;
        this.createdBy = createdBy;
        this.coverPhotoUrl = coverPhotoUrl;
        this.dateCreated = dateCreated;
    }

    @Length(max = 10)
    private String name;

    @ValidName
    private String createdBy;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    private String coverPhotoUrl;
    private Date dateCreated;
    public String getId() {
        return id;
    }

    public void setId(String id) {
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





}
