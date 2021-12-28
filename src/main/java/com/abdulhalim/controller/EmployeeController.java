package com.abdulhalim.controller;

import com.abdulhalim.entity.Employee;
import com.abdulhalim.dto.request.EmployeeRequestDto;
import com.abdulhalim.dto.response.DepartmentResponseDto;
import com.abdulhalim.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto){
       return new ResponseEntity(employeeService.createEmployee(employeeRequestDto), HttpStatus.CREATED);
  }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<DepartmentResponseDto> getAllDepartment(){
        return new ResponseEntity(employeeService.getAllEmployeeList(),HttpStatus.FOUND);
    }

    @PutMapping("/updateEmployeeBy/employee/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeRequestDto employeeRequestDto){
        return new ResponseEntity(employeeService.updateEmployee(id,employeeRequestDto),HttpStatus.NO_CONTENT);
    }

}
