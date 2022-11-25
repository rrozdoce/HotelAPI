package com.rrozdoce.hotelapi.rest.controllers;

import com.rrozdoce.hotelapi.domain.entities.Room;
import com.rrozdoce.hotelapi.repositories.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController {

    // usar DTO
    private RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }
    @GetMapping
     public List<Room> findAll() {
         return repository.findAll();
     }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody @Valid Room room) {
        return repository.save(room);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
