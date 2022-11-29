package com.rrozdoce.hotelapi.domain.repositories;

import com.rrozdoce.hotelapi.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
