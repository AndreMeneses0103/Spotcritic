package com.example.spotcritic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sng_id")
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(name = "sng_title")
    private String title;

    @NotNull
    @Column(name = "art_id")
    private Long artistId;

    @NotNull
    @Column(name = "alb_id")
    private Long albumId;

    @NotNull
    @Column(name = "sng_date")
    private LocalDateTime data;

    @NotNull
    @Column(name = "sng_genre")
    private Genre genre;

    @NotNull
    @Column(name = "sng_duration")
    private LocalTime duration;

    @NotNull
    @Column(name = "sng_popularity")
    private Integer popularity;
}
