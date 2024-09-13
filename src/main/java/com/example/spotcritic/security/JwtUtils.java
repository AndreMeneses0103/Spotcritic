package com.example.spotcritic.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.cfg.Environment;
import org.springframework.security.core.Authentication;

public class JwtUtils {

    private static final String KEY = "abc";

    public static String generateNewToken(Authentication user) throws JsonProcessingException{
        return null;
    }
}
