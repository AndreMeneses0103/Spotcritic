package com.example.spotcritic.repository;

import com.example.spotcritic.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findSongByTitle(String title);
}
