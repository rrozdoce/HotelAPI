package com.rrozdoce.hotelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HotelApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelApiApplication.class, args);

       System.out.println(new BCryptPasswordEncoder().encode("Felipe123"));
       System.out.println(new BCryptPasswordEncoder().encode("Lauro123"));
    }

}
