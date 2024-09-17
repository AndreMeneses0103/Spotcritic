package com.example.spotcritic.service;

import com.example.spotcritic.entity.Song;
import com.example.spotcritic.entity.Users;
import com.example.spotcritic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class SongService {
    @Autowired
    private SongRepository songRep;

    public Song newSong(Song song){
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Song invalid!");
        }

        if (song.getTitle() == null || song.getTitle().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title invalid!");
        }

        if (song.getGenre() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Genre invalid!");
        }

        if (song.getData() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Date invalid!");
        }

        if (song.getDuration() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duration invalid!");
        }

        if (song.getAlbumId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Album invalid!");
        }

        if (song.getArtists() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Artists invalid!");
        }

        return songRep.save(song);
    }

    public List<Song> findAllSongs(){
        return songRep.findAll();
    }

    public Optional<Song> findSongById(Long id){
        return songRep.findById(id);
    }

    public Optional<Song> findSongByTitle(String title){
        return songRep.findSongByTitle(title);
    }
}
