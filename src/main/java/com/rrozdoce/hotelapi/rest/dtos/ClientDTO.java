package com.rrozdoce.hotelapi.rest.dtos;

import com.rrozdoce.hotelapi.domain.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long employee;
    @NotEmpty(message = "Name shouldnt be null or empty")
    private String name;
    @NotEmpty(message = "Adress shouldnt be null or empty")
    private String adress;
    private Set<Room> rooms;
}
