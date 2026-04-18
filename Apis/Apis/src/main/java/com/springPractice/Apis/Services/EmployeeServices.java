package com.springPractice.Apis.Services;

import com.springPractice.Apis.Entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {

    public Employee addEmployee(Employee Employee);

    public List<Employee> getEmployees();

    public Employee getEmployeeById(long id);

    public List<Employee> getEmployeesByNameAndAge(String name, int age);

    public String updateEmployeeById(long id, Employee Employee);

    public String deleteEmployeeByID(long id);

    public String partialUpdateEmployeeById(long id, Map<String, String> updates);

}
