package com.example.spotcritic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alb_id")
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(name = "alb_title")
    private String title;

    @NotNull
    @Column(name = "art_id")
    private Long artistId;

    @NotNull
    @Column(name = "sng_date")
    private LocalDateTime data;

    @NotNull
    @Column(name = "alb_cover")
    private String cover;
}
