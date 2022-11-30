package com.rrozdoce.hotelapi.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                //.antMatchers(HttpMethod.GET, "/api/client","/api/room", "/api/employee").permitAll()
                //.antMatchers(HttpMethod.POST, "/api/client","/api/room", "/api/employee").hasAnyRole("USER", "ADMIN")
                //.antMatchers(HttpMethod.PUT, "/api/client","/api/room", "/api/employee").hasAnyRole("ADMIN")
                //.antMatchers(HttpMethod.DELETE, "/api/client","/api/room", "/api/employee").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
