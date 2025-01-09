package com.company.employee_service.service;

import com.company.employee_service.dto.EmployeeDepartment;
import com.company.employee_service.entity.Employee;

public interface EmployeeService {

    Employee getAllEmployeeById(Long id);
    Employee addEmployee(Employee employee);
    EmployeeDepartment getEmployeeAndDepartmentbyId(Long employeeId);
}
