package com.rrozdoce.hotelapi.rest.dtos;

import com.rrozdoce.hotelapi.domain.entities.Room;

import java.util.Set;

public class ClientDTO {
    private String name;
    private String adress;
    private Set<Room> rooms;
}
