package com.example.spotcritic.repository;

import com.example.spotcritic.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
