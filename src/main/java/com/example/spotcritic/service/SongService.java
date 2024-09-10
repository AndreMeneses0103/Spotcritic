package com.example.spotcritic.service;

import com.example.spotcritic.entity.Song;
import com.example.spotcritic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongService {
    @Autowired
    private SongRepository songRep;

    public List<Song> findAllSongs(){
        return songRep.findAll();
    }
}
