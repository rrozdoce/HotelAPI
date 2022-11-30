package com.rrozdoce.hotelapi.rest.controllers;

import com.rrozdoce.hotelapi.domain.entities.Employee;
import com.rrozdoce.hotelapi.domain.repositories.EmployeeRepository;
import com.rrozdoce.hotelapi.rest.dtos.EmployeeDTO;
import com.rrozdoce.hotelapi.service.impl.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public List<Employee> findAll() {
       return service.findAll();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee save(@RequestBody @Valid EmployeeDTO dto) {
        return service.save(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee att(@RequestBody @Valid EmployeeDTO dto, @PathVariable Long id) { return service.update(dto, id);}
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
