package com.company.department_service.service;

import com.company.department_service.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentById(Long departmentId);

    Department addDepartment(Department department);

    Department updateDepartment(Long departmentId,Department department);

    void deleteDepartment(Long departmentId);
}
