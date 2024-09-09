package com.example.spotcritic.service;

import com.example.spotcritic.entity.User;
import com.example.spotcritic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRep;

    public User newUser(User user){
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User invalid!");
        }

        if (user.getFirstname() == null || user.getFirstname().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User First name invalid!");
        }

        if (user.getLastname() == null || user.getLastname().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Last name invalid!");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User email invalid!");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User password invalid!");
        }

        if (user.getNickname() == null || user.getNickname().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User nickname invalid!");
        }

        return userRep.save(user);
    }
}
