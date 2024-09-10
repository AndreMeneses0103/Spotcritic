package com.example.spotcritic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_song", schema = "spotcritic")
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
    @ManyToMany
    @JoinTable(
        name = "tb_song_artist",
        joinColumns = @JoinColumn(name = "sng_id"),
        inverseJoinColumns = @JoinColumn(name = "art_id")
    )
    private Set<Artist> artists;

    @ManyToOne
    @JoinColumn(name = "alb_id")
    private Album albumId;

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
