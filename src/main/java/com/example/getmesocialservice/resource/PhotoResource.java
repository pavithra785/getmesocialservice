package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.service.PhotoService;
import com.example.getmesocialservice.validation.ValidName;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;
    @Autowired
    private FirebaseService firebaseService;
    @GetMapping
    public List<Photo> getAlbumList(){
        return photoService.getPhotoList();
    }

    @PostMapping
    public Photo saveAlbum(@RequestBody @Valid Photo photo, @RequestHeader(name="idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return  photoService.savePhoto(photo);
        }
       return null;
    }


    @GetMapping("/find")
    public Optional<Photo> getPhotoById(@RequestParam(name = "photoId") String photoId) {
        return photoService.getPhotoById(photoId);
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody @Valid Photo photo ,@RequestHeader(name="idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return photoService.updatePhoto(photo);
        }
        return null;
    }




    @DeleteMapping
    public void deletePhoto( @RequestParam (name = "photoId") String photoId,@RequestHeader(name="idToken")String idToken ) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            photoService.deletePhoto(photoId);
        }

    }

}
