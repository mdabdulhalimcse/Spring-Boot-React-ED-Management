package com.abdulhalim.controller;


import com.abdulhalim.dto.request.EmployeeRequestDto;
import com.abdulhalim.entity.Department;
import com.abdulhalim.dto.request.DepartmentRequestDto;
import com.abdulhalim.dto.response.DepartmentResponseDto;
import com.abdulhalim.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService deptService;

    @PostMapping("/create")
    public ResponseEntity<Department> saveEmployee(@Valid @RequestBody DepartmentRequestDto departmentRequestDto){
        return new ResponseEntity(deptService.createDepartment(departmentRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateDepartmentBy/department/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id,@Valid @RequestBody DepartmentRequestDto departmentRequestDto){
        return new ResponseEntity(deptService.updateDepartment(id,departmentRequestDto),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAllDepartment")
    public ResponseEntity<DepartmentResponseDto> getAllDepartment(){
        return new ResponseEntity(deptService.getAllDepartmentList(),HttpStatus.OK);
    }

}
