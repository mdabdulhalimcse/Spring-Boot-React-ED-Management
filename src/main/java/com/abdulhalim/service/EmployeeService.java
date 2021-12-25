package com.abdulhalim.service;


import com.abdulhalim.dto.EmployeeDto;
import com.abdulhalim.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Object saveEmployee(Employee employee);
    Object updateEmployee(Employee employee);
    Object deleteEmployeeById(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployee();

    List<EmployeeDto> findAllEmployee();
    EmployeeDto convertEntityToDto(Employee employee);
}
