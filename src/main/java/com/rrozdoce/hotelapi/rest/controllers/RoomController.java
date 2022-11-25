package com.rrozdoce.hotelapi.rest.controllers;

import com.rrozdoce.hotelapi.domain.entities.Room;
import com.rrozdoce.hotelapi.rest.dtos.RoomDTO;
import com.rrozdoce.hotelapi.service.impl.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/room")
public class RoomController {

    // usar DTO
    private RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
     public List<Room> findAll() {
        return service.findAll();
     }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody @Valid RoomDTO dto) {
       return service.save(dto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void att(@RequestBody @Valid RoomDTO dto, @PathVariable Long id) { service.att(dto, id);}

}
