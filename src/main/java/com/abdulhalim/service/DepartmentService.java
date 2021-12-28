package com.abdulhalim.service;

import com.abdulhalim.dto.request.EmployeeRequestDto;
import com.abdulhalim.entity.Department;
import com.abdulhalim.dto.request.DepartmentRequestDto;
import com.abdulhalim.dto.response.DepartmentResponseDto;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {

    ResponseEntity<Department> createDepartment(DepartmentRequestDto departmentRequestDto);

    ResponseEntity<Void> updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto);

    ResponseEntity<DepartmentResponseDto> getAllDepartmentList();

    DepartmentResponseDto getDepartmentBy(Long id);
}
