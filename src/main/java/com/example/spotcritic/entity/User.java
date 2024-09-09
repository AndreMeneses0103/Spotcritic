package com.example.spotcritic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usr_first_name")
    private String firstname;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usr_last_name")
    private String lastname;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usr_nickname")
    private String nickname;

    @NotNull
    @Size(min = 6)
    @Column(name = "usr_password")
    private String password;

    @NotNull
    @Email
    @Column(name = "usr_email")
    private String email;

    @NotNull
    @Column(name = "usr_country")
    private Country country;

    @NotNull
    @Column(name = "usr_data")
    private LocalDateTime data;

    @Column(name = "usr_avatar")
    private String avatar;
}
