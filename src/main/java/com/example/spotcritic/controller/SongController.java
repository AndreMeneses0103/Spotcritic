package com.example.spotcritic.controller;

import com.example.spotcritic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song")
@CrossOrigin("*")
public class SongController {
    @Autowired
    private SongService songServ;


}
