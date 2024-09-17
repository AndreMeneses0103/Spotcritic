package com.example.spotcritic.service;

import com.example.spotcritic.entity.Artist;
import com.example.spotcritic.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRep;

    public Artist newArtist(Artist artist){
        if(artist == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Artist invalid!");
        }

        if (artist.getName() == null || artist.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Artist name invalid!");
        }

        if (artist.getBio() == null || artist.getBio().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Artist Biograph invalid!");
        }

        if(artist.getCountry() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Artist Country invalid!");
        }

        return artistRep.save(artist);
    }

    public Optional<Artist> getArtistByName(String name){
        return artistRep.findArtistByName(name);
    }
}
