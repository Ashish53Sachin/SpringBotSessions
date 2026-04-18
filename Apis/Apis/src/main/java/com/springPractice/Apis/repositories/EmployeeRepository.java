package com.springPractice.Apis.repositories;

import com.springPractice.Apis.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query("update employee set Emp where id = :id")
//    public void updateEmployeeByIdAndEmp(@Param("id") Long id, Employee e);
}
