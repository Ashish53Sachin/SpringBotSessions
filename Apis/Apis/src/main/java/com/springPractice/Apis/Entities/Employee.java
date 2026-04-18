package com.springPractice.Apis.Entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;


@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EMP_ID")
    private long empId;

    @Column(name="EMP_NAME")
    private String empName;

    @Column(name="EMP_MANAGER_NAME")
    private String managerName;

    @Column(name="EMP_DEPARTMENT")
    private String department;

    @Column(name="EMP_AGE")
    private int empAge;

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", empId=" + empId +
                ", empName='" + empName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", empAge=" + empAge +
                '}';
    }
}
