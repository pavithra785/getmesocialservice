package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.FirebaseUser;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.FirebaseService;
import com.example.getmesocialservice.validation.ValidName;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping
    public List<Album> getAlbumList(){
        return albumService.getAlbumList();
    }

    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album,@RequestHeader(name="idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return  albumService.saveAlbum(album);
        }
        return null;
    }


    @GetMapping("/find")
    public Optional<Album> getAlbumById(@RequestParam(name = "albumId") String albumId) {
        return albumService.getAlbumById(albumId);
    }

    @PutMapping
    public Album updateAlbum(@RequestBody @Valid Album album , @RequestHeader(name="idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            return albumService.updateAlbum(album);
        }
        return null;
    }

    @DeleteMapping
    public void deleteAlbum( @RequestParam (name = "albumid") String albumid,@RequestHeader(name="idToken")String idToken ) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            albumService.deleteAlbum(albumid);
        }

    }


//    @PutMapping("/album/{albumId}")
//    public Album updateAlbum( @PathVariable ("albumId") int albumId, @RequestBody Album album ){
//        return albumService.updateAlbum(albumId, album);
//    }

//    @DeleteMapping("/album")
//    public Album deleteAlbum( @RequestParam (name = "albumId") int albumId ){
//        return albumService.deleteAlbum(albumId);
//    }
}
