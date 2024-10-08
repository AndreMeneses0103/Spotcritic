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
@Table(name = "tb_album", schema = "spotcritic")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alb_id")
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(name = "alb_title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "art_id", nullable = false)
    private Artist artist;

    @NotNull
    @Column(name = "sng_date")
    private LocalDateTime data;

    @NotNull
    @Column(name = "alb_cover")
    private String cover;
}
