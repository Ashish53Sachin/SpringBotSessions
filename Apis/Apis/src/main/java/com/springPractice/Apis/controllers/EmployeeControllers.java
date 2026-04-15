package com.springPractice.Apis.controllers;

import com.springPractice.Apis.Entities.Employee;
import com.springPractice.Apis.Services.EmployeeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
            return ResponseEntity.ok("EMPLOYEE ADDED SUCCESSFULLY!!");

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
    public Employee getEmployeeById(@PathVariable int id) {

        Employee employee = employeeServices.getEmployeeById(id);
        return ResponseEntity.ok(employee).getBody();
    }

}
