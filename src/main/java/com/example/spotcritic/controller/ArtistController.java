package com.example.spotcritic.controller;

import com.example.spotcritic.entity.Artist;
import com.example.spotcritic.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/artist")
@CrossOrigin("*")
public class ArtistController {
    @Autowired
    private ArtistService artistServ;

    public ResponseEntity<Artist> newArtist(@RequestBody Artist artist){
        return ResponseEntity.status((HttpStatus.OK)).body(artistServ.newArtist(artist));
    }

    public ResponseEntity<Optional<Artist>> getArtistByName(@RequestParam("name") String name){
        return ResponseEntity.status((HttpStatus.OK)).body((artistServ.getArtistByName(name)));
    }
}
