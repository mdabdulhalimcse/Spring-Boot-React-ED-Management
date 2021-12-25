package com.abdulhalim.service;

import com.abdulhalim.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department dept);
    Department updateDepartment(Department department);
    Object deleteDepartmentById(Long id);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartment();
}
