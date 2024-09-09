package com.example.spotcritic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rtg_id")
    private Long id;

    @NotNull
    @Column(name = "usr_id")
    private Long userId;

    @NotNull
    @Column(name = "sng_id")
    private Long songId;

    @NotNull
    @Column(name = "rtg_score")
    private Double score;

    @Column(name = "rtg_comment")
    private String comment;

    @NotNull
    @Column(name = "rtg_date")
    private LocalDateTime date;
}
