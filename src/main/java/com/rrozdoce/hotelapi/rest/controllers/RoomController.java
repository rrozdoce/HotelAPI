package com.rrozdoce.hotelapi.rest.controllers;

import com.rrozdoce.hotelapi.domain.entities.Room;
import com.rrozdoce.hotelapi.rest.dtos.RoomDTO;
import com.rrozdoce.hotelapi.service.impl.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/room")
public class RoomController {
    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
     public List<Room> findAll() {
        return service.findAll();
     }
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody @Valid RoomDTO dto) {
       return service.save(dto);
    }
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Room att(@RequestBody @Valid RoomDTO dto, @PathVariable Long id) { return service.att(dto, id);}

}
