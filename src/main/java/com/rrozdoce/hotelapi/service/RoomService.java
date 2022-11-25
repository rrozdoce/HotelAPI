package com.rrozdoce.hotelapi.service;

import com.rrozdoce.hotelapi.repositories.RoomRepository;

public class RoomService {

    private RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    // code
}
