package com.rrozdoce.hotelapi.service;

import com.rrozdoce.hotelapi.domain.entities.Employee;
import com.rrozdoce.hotelapi.rest.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeServiceImpl {

    Employee save(EmployeeDTO dto);
    List<Employee> findAll();
    void delete(Long id);
    Employee update(EmployeeDTO dto, Long id);
}
