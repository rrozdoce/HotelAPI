package com.rrozdoce.hotelapi.rest.controllers;

import com.rrozdoce.hotelapi.domain.entities.Room;
import com.rrozdoce.hotelapi.repositories.RoomRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController {

    private RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }
    @GetMapping
     public List<Room> findAll() {
         return repository.findAll();
     }


}
