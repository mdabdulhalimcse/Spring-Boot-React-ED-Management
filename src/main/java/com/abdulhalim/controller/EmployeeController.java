package com.abdulhalim.controller;

import com.abdulhalim.dto.EmployeeDto;
import com.abdulhalim.entity.Employee;
import com.abdulhalim.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/")
    public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(this.employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(this.employeeService.updateEmployee(employee),HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(this.employeeService.getAllEmployee(),HttpStatus.FOUND);
    }

    @GetMapping(value = "/employeeBy/{id}")
    public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable Long id){
        return new ResponseEntity(this.employeeService.getEmployeeById(id),HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<Object> deleteEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(this.employeeService.deleteEmployeeById(employee.getId()),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.employeeService.deleteEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<EmployeeDto>> listEmployee(){
        return new ResponseEntity<>(this.employeeService.findAllEmployee(),HttpStatus.FOUND);
    }

}
