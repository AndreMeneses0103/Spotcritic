package com.example.spotcritic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private Long id;

    @NotNull
    @Column(name = "art_name")
    private String name;

    @NotNull
    @Column(name = "art_country")
    private Country country;

    @NotNull
    @Column(name = "art_bio")
    private String bio;

    @OneToMany(mappedBy = "artist")
    private Set<Album> albums;
}
