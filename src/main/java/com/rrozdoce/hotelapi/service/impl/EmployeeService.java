package com.rrozdoce.hotelapi.service.impl;

import com.rrozdoce.hotelapi.domain.entities.Employee;
import com.rrozdoce.hotelapi.domain.repositories.EmployeeRepository;
import com.rrozdoce.hotelapi.rest.dtos.EmployeeDTO;
import com.rrozdoce.hotelapi.service.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public Employee save(EmployeeDTO dto) {
        Employee employee = convert(dto);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
         employeeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Employee update(EmployeeDTO dto, Long id) {
        Employee employee = convert(dto);
       return employeeRepository
                .findById(id)
                .map(OldEmployee-> {
                    employee.setEmployee_id(OldEmployee.getEmployee_id());
                    employeeRepository.save(employee);
                    return employee;
                }).orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee not found!!"));
    }

    public Employee convert(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setAdress(dto.getAdress());
        return employee;
    }
}
