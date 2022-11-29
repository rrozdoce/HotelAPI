package com.rrozdoce.hotelapi.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name shouldnt be null or empty")
    private String name;
    @NotEmpty(message = "Adress shouldnt be null or empty")
    private String adress;
    private Set<ClientDTO> client;
}