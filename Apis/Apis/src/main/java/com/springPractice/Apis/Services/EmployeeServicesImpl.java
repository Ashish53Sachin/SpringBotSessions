package com.springPractice.Apis.Services;

import com.springPractice.Apis.Entities.Employee;
import com.springPractice.Apis.Exceptions.ResourceNotFoundException;
import com.springPractice.Apis.controllers.EmployeeControllers;
import com.springPractice.Apis.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServicesImpl implements EmployeeServices{

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger log = LoggerFactory.getLogger(EmployeeServicesImpl.class);

    @Override
    public Employee addEmployee(Employee employee) {
        try
        {if(employee != null)
            {
                log.info("Employee is being added to DataBase!!");
                return employeeRepository.save(employee);
            }
        }catch(Exception ex)
        {
            log.error("Unable to add Employee DataBase via Service!!");
        }
        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return List.of();
    }

    @Override
    public Employee getEmployeeById(long id) {
        try {
            Employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No" +
                    "Employee Exists with this id: "+ id));
            return emp;

        }catch(Exception e)
        {
            throw new RuntimeException("Error fetching employee with id: " + id, e);
        }
    }

    @Override
    public List<Employee> getEmployeesByNameAndAge(String name, int age) {
        return List.of();
    }

    /*
    check id exists or not, if yes, then update elso no update
     */
    @Override
    @Transactional
    public String updateEmployeeById(long id, Employee employee) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        existing.setEmpName(employee.getEmpName());
        existing.setManagerName(employee.getManagerName());
        existing.setDepartment(employee.getDepartment());
        existing.setEmpAge(employee.getEmpAge());

        employeeRepository.save(existing);

        return "Employee is updated!!";
    }

    @Override
    @Transactional
    public String partialUpdateEmployeeById(long id, Map<String, String> updates) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        if (updates.containsKey("empName")) {
            existing.setEmpName(updates.get("empName"));
        }
        if (updates.containsKey("managerName")) {
            existing.setManagerName(updates.get("managerName"));
        }
        employeeRepository.save(existing);

        return "Employee is updated!!";
    }

    @Override
    @Transactional
    public String deleteEmployeeByID(long id) {

        employeeRepository.deleteById(id);
        return "Employee with id: "+id+" is deleted !!";
    }
}
