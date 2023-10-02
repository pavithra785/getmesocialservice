package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.validation.ValidName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> getAlbumList(){
        return albumService.getAlbumList();
    }

    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album){
        return  albumService.saveAlbum(album);
    }


    @GetMapping("/find")
    public Optional<Album> getAlbumById(@RequestParam(name = "albumId") String albumId) {
        return albumService.getAlbumById(albumId);
    }

    @PutMapping
    public Album updateAlbum(@RequestBody @Valid Album album ){
        return albumService.updateAlbum(album);
    }

    @DeleteMapping
    public void deleteAlbum( @RequestParam (name = "albumid") String albumid ){
        albumService.deleteAlbum(albumid);
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
