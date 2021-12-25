package com.abdulhalim.controller;


import com.abdulhalim.entity.Department;
import com.abdulhalim.entity.Employee;
import com.abdulhalim.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService deptService;

    @PostMapping("/")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department dept){
        return new ResponseEntity<>(this.deptService.saveDepartment(dept), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department dept){
        return new ResponseEntity<>(this.deptService.updateDepartment(dept), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Department>> getAllDepartment(){
        return new ResponseEntity<>(this.deptService.getAllDepartment(),HttpStatus.FOUND);
    }

    @GetMapping(value = "/departmentBy/{id}")
    public ResponseEntity<List<Department>> getEmployeesById(@PathVariable Long id){
        return new ResponseEntity(deptService.getDepartmentById(id),HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<Object> deleteDepartment(@RequestBody Employee employee){
        return new ResponseEntity<>(this.deptService.deleteDepartmentById(employee.getId()),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteDepartmentById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.deptService.deleteDepartmentById(id),HttpStatus.OK);
    }
}
