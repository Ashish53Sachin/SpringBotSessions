package com.springPractice.Apis.controllers;

import com.springPractice.Apis.Entities.Employee;
import com.springPractice.Apis.Services.EmployeeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class EmployeeControllers {

    private static final Logger log = LoggerFactory.getLogger(EmployeeControllers.class);

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("/addingEmp")
    public ResponseEntity<String> addEmployee(@RequestBody Employee emp)
    {
        try{
            log.info("adding Employee into DB!!");
            employeeServices.addEmployee(emp);
            // Build URI for the new resource
            URI location = URI.create("/employees/" + emp.getEmpId());

            return ResponseEntity.created(location)
                    .body("EMPLOYEE ADDED SUCCESSFULLY!!");
        }catch(Exception e)
        {
            log.error("error while adding employee Emp!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add employee: " + e.getMessage());
        }
    }
//
//    @GetMapping
//    public ResponseEntity<String> getEmployee()
//    {
//        try{
//
//        }catch(Exception e)
//        {
//
//        }
//    }

    @GetMapping("emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {

        Employee employee = employeeServices.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("emp/{id}")
    public ResponseEntity<String> delEmployeeById(@PathVariable int id) {
            employeeServices.deleteEmployeeByID(id);
        return ResponseEntity.ok("employee is deleted!!");
    }

    @PutMapping("emp/{id}")
    public ResponseEntity<String> putEmployeeById(@PathVariable int id, @RequestBody Employee emp) {
        employeeServices.updateEmployeeById(id, emp);
        return ResponseEntity.ok("employee is updated!!");
    }

    @PatchMapping("emp/{id}")
    public ResponseEntity<String> partialUpdEmployeeById(@PathVariable int id, @RequestBody Map<String, String> updates) {
        employeeServices.partialUpdateEmployeeById(id, updates);
        return ResponseEntity.ok("employee is updated!!");
    }

}
