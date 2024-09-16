package com.example.spotcritic.service;

import com.example.spotcritic.entity.Users;
import com.example.spotcritic.entity.Authorization;
import com.example.spotcritic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;


import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    private UserRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userOp = userRep.findUsersByNickname(username);

        if(userOp.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }

        Users user = userOp.get();
        return User.builder().username(user.getNickname()).password(user.getPassword()).authorities(user.getAuthorizations().stream().map(Authorization::getName).collect(Collectors.toList()).toArray(new String[user.getAuthorizations().size()])).build();
    }
}
