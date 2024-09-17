package com.example.spotcritic.controller;

import com.example.spotcritic.entity.Song;
import com.example.spotcritic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/song")
@CrossOrigin("*")
public class SongController {
    @Autowired
    private SongService songServ;

    @GetMapping
    public ResponseEntity<Optional<Song>> getSongByTitle(@RequestParam("title") String title){
        return ResponseEntity.status((HttpStatus.OK)).body(songServ.findSongByTitle(title));
    }
}
