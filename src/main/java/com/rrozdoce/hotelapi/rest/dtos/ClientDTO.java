package com.rrozdoce.hotelapi.rest.dtos;

import com.rrozdoce.hotelapi.domain.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private String name;
    private String adress;
    private Set<Room> rooms;
}
