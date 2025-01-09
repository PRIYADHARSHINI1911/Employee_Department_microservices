package com.company.employee_service.service;

import com.company.employee_service.dto.Department;
import com.company.employee_service.dto.EmployeeDepartment;
import com.company.employee_service.entity.Employee;
import com.company.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Employee getAllEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDepartment getEmployeeAndDepartmentbyId(Long employeeId) {
        //getEmployee
        Employee employee = employeeRepository.findById(employeeId).get();

        //getDepartment
        Department department = restTemplate.getForObject("http://department-service/api/department/"+
                        employee.getDepartmentId(),
                Department.class);

        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
        employeeDepartment.setEmployee(employee);
        employeeDepartment.setDepartment(department);
        return employeeDepartment;
    }
}
