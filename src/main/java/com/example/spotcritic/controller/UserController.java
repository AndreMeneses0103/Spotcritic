package com.example.spotcritic.controller;

import com.example.spotcritic.entity.Users;
import com.example.spotcritic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userServ;

    @PostMapping(path = "/newUser")
    public ResponseEntity<Users> postNewUser(@RequestBody Users users){
        return ResponseEntity.status(HttpStatus.OK).body(userServ.newUser(users));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Users>> getUserByNickname(@PathVariable("id") Long id){
        return ResponseEntity.status((HttpStatus.OK)).body(userServ.getUserById(id));
    }
}
