package com.example.spotcritic.controller;

import com.example.spotcritic.entity.User;
import com.example.spotcritic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userServ;

    @PostMapping(path = "/newUser")
    public ResponseEntity<User> postNewUser(@RequestBody User user){
        System.out.println(user);
        return ResponseEntity.status(HttpStatus.OK).body(userServ.newUser(user));
    }
}
