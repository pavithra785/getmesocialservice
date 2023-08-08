package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public List<Album> getAlbumList(){
        return albumService.getAlbumList();
    }

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album album){
        return  albumService.saveAlbum(album);
    }


    @GetMapping("/album/{albumId}")
    public Album getAlbumById( @PathVariable ("albumId") int albumId ){
        return albumService.getAlbumById(albumId);
    }

    @PutMapping("/album/{albumId}")
    public Album updateAlbum( @PathVariable ("albumId") int albumId, @RequestBody Album album ){
        return albumService.updateAlbum(albumId, album);
    }


    @DeleteMapping("/album")
    public Album deleteAlbum( @RequestParam (name = "albumId") int albumId ){
        return albumService.deleteAlbum(albumId);
    }
}
