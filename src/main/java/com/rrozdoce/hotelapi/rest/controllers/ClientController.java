package com.rrozdoce.hotelapi.rest.controllers;

import com.rrozdoce.hotelapi.domain.entities.Client;
import com.rrozdoce.hotelapi.rest.dtos.ClientDTO;
import com.rrozdoce.hotelapi.service.impl.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid ClientDTO client) {
       return service.save(client);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Client att(@RequestBody @Valid ClientDTO dto, @PathVariable Long id){
       return service.update(dto, id);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable  Long id) {
        service.delete(id);
    }
}