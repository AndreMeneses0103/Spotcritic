package com.example.spotcritic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Desabilita CSRF
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().permitAll() // Permite acesso a todas as requisições sem autenticação
                );
        return http.build();
    }
}
