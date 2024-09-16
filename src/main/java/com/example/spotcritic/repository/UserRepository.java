package com.example.spotcritic.repository;

import com.example.spotcritic.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findUsersByNickname(String nickname);
}
