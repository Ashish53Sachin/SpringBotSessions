package com.springPractice.Apis.repositories;

import com.springPractice.Apis.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
