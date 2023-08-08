package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AlbumRepository {

    List<Album> albumList= new ArrayList();
    public List<Album> getAlbumList() {
        return albumList;
    }


    public Album saveAlbum(Album album) {
        int albumId= albumList.size() + 1;
        album.setAlbumId(albumId);
        albumList.add(album);
        return  album;
    }

    public Album getAlbumById(int albumId) {
        for(Album album: albumList){
            if(album.getAlbumId()==albumId){
                return album;
            }
        }
        return null;
    }

    public Album updateAlbum(int albumId, Album album) {
        for(Album al: albumList){
            if(albumId==al.getAlbumId()){
                al.setName(album.getName());
                al.setDescription(al.getDescription());
                al.setCoverPicUrl(al.getCoverPicUrl());
                return al;
            }
        }
        return null;
    }

    public Album deleteAlbum(int albumId) {
        Album deletedAlbum=null;
        for (Album al:albumList) {
            if (al.getAlbumId() == albumId) {
                deletedAlbum = al;
                albumList.remove(al);
                return deletedAlbum;
            }
        }

        return deletedAlbum;
    }
    }

