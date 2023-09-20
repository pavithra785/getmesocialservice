package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;
    @GetMapping
    public List<Photo> getAlbumList(){
        return photoService.getPhotoList();
    }

    @PostMapping
    public Photo saveAlbum(@RequestBody Photo photo){
        return  photoService.savePhoto(photo);
    }


    @GetMapping("/find")
    public Optional<Photo> getPhotoById(@RequestParam(name = "photoId") String photoId) {
        return photoService.getPhotoById(photoId);
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo ){
        return photoService.updatePhoto(photo);
    }




    @DeleteMapping
    public void deletePhoto( @RequestParam (name = "photoId") String photoId ){
        photoService.deletePhoto(photoId);
    }

}
