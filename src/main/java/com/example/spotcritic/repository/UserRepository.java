package com.example.spotcritic.repository;

import com.example.spotcritic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
