package com.example.spotcritic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_aut", schema = "spotcritic")
public class Authorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    @Column(name = "aut_name")
    private String name;

    @ManyToMany(mappedBy = "authorizations", fetch = FetchType.LAZY)
    private Set<Users> usuarios;


}
