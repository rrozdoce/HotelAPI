package com.rrozdoce.hotelapi.domain.repositories;

import com.rrozdoce.hotelapi.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
