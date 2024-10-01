package com.example.spotcritic.service;

import com.example.spotcritic.entity.Users;
import com.example.spotcritic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRep;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Users newUser(Users users){
        if (users == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User invalid!");
        }

        if (users.getFirstname() == null || users.getFirstname().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User First name invalid!");
        }

        if (users.getLastname() == null || users.getLastname().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Last name invalid!");
        }

        if (users.getEmail() == null || users.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User email invalid!");
        }

        if (users.getPassword() == null || users.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User password invalid!");
        }

        if (users.getNickname() == null || users.getNickname().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User nickname invalid!");
        }

        return userRep.save(users);
    }

    public Optional<Users> getUserById(Long id){
        Users cacheUsers = (Users) redisTemplate.opsForHash().get("users", id.toString());

        if(cacheUsers != null){
            return Optional.of(cacheUsers);
        }

        Optional<Users> users = userRep.findById(id);
        users.ifPresent(users1 -> redisTemplate.opsForHash().put("users", users1.toString(), id));
        return users;
    }

    public Optional<Users> getUserByNickname(String nick){
        return userRep.findUsersByNickname(nick);
    }

    public boolean deleteUserById(Long id){
        if(getUserById(id).isPresent()){
            userRep.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Users> getAllUsers(){
        return userRep.findAll();
    }
}
