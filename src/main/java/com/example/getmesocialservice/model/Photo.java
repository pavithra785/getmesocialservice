package com.example.getmesocialservice.model;

import com.example.getmesocialservice.validation.ValidName;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Photo {

    public Photo(String albumId, String photoUrl, String userEmail, Date dateCreated) {
        this.albumId = albumId;
        this.photoUrl = photoUrl;
        this.userEmail = userEmail;
        this.dateCreated = dateCreated;
    }

    @Id
    private int id;
    private String albumId;
    private String photoUrl;
    @ValidName
    private String userEmail;
    private Date dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String createdBy) {
        this.userEmail = userEmail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


}
