package com.springPractice.Apis.Services;

import com.springPractice.Apis.Entities.Employee;
import com.springPractice.Apis.Exceptions.ResourceNotFoundException;
import com.springPractice.Apis.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices{



    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(Employee employee) {
        try
        {
            if(employee != null)
            {
                employeeRepository.save(employee);
            }

        }catch(Exception ex)
        {

        }
        return "";
    }

    @Override
    public List<Employee> getEmployees() {
        return List.of();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee emp=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No" +
                "Employee Exists with this id: {}",id));
        return emp;
    }

    @Override
    public List<Employee> getEmployeesByNameAndAge(String name, int age) {
        return List.of();
    }

    @Override
    public String updateEmployeeById(Employee Employee) {
        return "";
    }
}
