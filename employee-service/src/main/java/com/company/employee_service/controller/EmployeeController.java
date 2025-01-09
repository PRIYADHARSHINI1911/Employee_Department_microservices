package com.company.employee_service.controller;

import com.company.employee_service.dto.EmployeeDepartment;
import com.company.employee_service.entity.Employee;
import com.company.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId){
        return employeeService.getAllEmployeeById(employeeId);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}/department")
    public EmployeeDepartment getEmployeeAndDepartment(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeAndDepartmentbyId(employeeId);
    }
}
