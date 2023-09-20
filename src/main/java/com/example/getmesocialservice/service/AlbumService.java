package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;
    public List<Album> getAlbumList() {
        return  albumRepository.findAll();
    }

    public Album saveAlbum(Album album) {
        return  albumRepository.save(album);
    }

    public Optional<Album> getAlbumById(String albumId) {
        return albumRepository.findById(albumId);
    }


    public Album updateAlbum( Album album) {
        return albumRepository.save(album);
    }

    public void deleteAlbum(String albumId) {
         albumRepository.deleteById(albumId);
    }

}
