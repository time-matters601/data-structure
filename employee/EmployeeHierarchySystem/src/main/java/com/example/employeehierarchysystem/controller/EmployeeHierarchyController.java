// In EmployeeHierarchyController.java
package com.example.employeehierarchysystem.controller;



import com.example.employeehierarchysystem.model.Employee;
import com.example.employeehierarchysystem.service.EmployeeHierarchyService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeHierarchyController {

    private final EmployeeHierarchyService employeeHierarchyService;

    public EmployeeHierarchyController(EmployeeHierarchyService employeeHierarchyService) {
        this.employeeHierarchyService = employeeHierarchyService;
    }

    @GetMapping("/hierarchy")
    public String getHierarchy() {
        return employeeHierarchyService.getHierarchyAsString();
    }

    @GetMapping("/in-order")
    public List<Employee> getEmployeesInOrder() {
        return employeeHierarchyService.getEmployeesInOrder();
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        employeeHierarchyService.addEmployee(employee);
        return "Employee added to the hierarchy";
    }
}