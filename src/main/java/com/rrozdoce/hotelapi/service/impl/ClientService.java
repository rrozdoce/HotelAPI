package com.rrozdoce.hotelapi.service.impl;

import com.rrozdoce.hotelapi.domain.entities.Client;
import com.rrozdoce.hotelapi.rest.dtos.ClientDTO;
import com.rrozdoce.hotelapi.service.ClientServiceImpl;

import java.util.List;

public class ClientService implements ClientServiceImpl {


    @Override
    public Client save(ClientDTO dto) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(ClientDTO dto, Long id) {

    }
}
