package com.abdulhalim.service;


import com.abdulhalim.entity.Employee;
import com.abdulhalim.dto.request.EmployeeRequestDto;
import com.abdulhalim.dto.response.EmployeeResponseDto;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<Employee> createEmployee(EmployeeRequestDto employeeRequestDto);

    ResponseEntity<Void> updateEmployee(Long employeeId,EmployeeRequestDto employeeRequestDto);

    ResponseEntity<EmployeeResponseDto> getAllEmployeeList();
}
