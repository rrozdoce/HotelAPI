package com.rrozdoce.hotelapi.rest.controllers;

import com.rrozdoce.hotelapi.domain.entities.Employee;
import com.rrozdoce.hotelapi.domain.repositories.EmployeeRepository;
import com.rrozdoce.hotelapi.rest.dtos.EmployeeDTO;
import com.rrozdoce.hotelapi.service.impl.EmployeeService;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    public List<Employee> findAll() {
       return service.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee save(@RequestBody @Valid EmployeeDTO dto) {
        return service.save(dto);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee att(@RequestBody @Valid EmployeeDTO dto, @PathVariable Long id) { return service.update(dto, id);}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
