package com.rrozdoce.hotelapi.service;

import com.rrozdoce.hotelapi.domain.entities.Client;
import com.rrozdoce.hotelapi.rest.dtos.ClientDTO;

import java.util.List;

public interface ClientServiceImpl {
    Client save(ClientDTO dto);
    List<Client> findAll();
    void delete(Long id);
    void update(ClientDTO dto, Long id);
}
