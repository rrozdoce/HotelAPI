package com.rrozdoce.hotelapi.rest.controllers;

import com.rrozdoce.hotelapi.domain.entities.Employee;
import com.rrozdoce.hotelapi.repositories.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Employee> findAll() {
       return repository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee save(@RequestBody @Valid Employee employee) {
        return repository.save(employee);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
