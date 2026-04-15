package com.springPractice.Apis.Services;

import com.springPractice.Apis.Entities.Employee;

import java.util.List;

public interface EmployeeServices {

    public String addEmployee(Employee Employee);

    public List<Employee> getEmployees();

    public Employee getEmployeeById(long id);

    public List<Employee> getEmployeesByNameAndAge(String name, int age);

    public String updateEmployeeById(Employee Employee);


}
