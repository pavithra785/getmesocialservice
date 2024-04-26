package com.example.getmesocialservice.model;

import com.example.getmesocialservice.validation.ValidName;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import java.util.Date;

public class Comment {
    @Id
    private int id;

    public Comment(String photoId, String message, String userEmail, Date dateCreated) {
        this.photoId = photoId;
        this.message = message;
        this.userEmail = userEmail;
        this.dateCreated = dateCreated;
    }

    private String photoId;
    @Length(min = 5)
    private String message;
    @ValidName
    private String userEmail;
    private Date dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


}
