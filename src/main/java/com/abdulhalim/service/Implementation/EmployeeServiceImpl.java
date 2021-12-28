package com.abdulhalim.service.Implementation;

import com.abdulhalim.config.UniqueKeyConfiguration;
import com.abdulhalim.entity.Department;
import com.abdulhalim.entity.Employee;
import com.abdulhalim.dto.request.EmployeeRequestDto;
import com.abdulhalim.dto.response.EmployeeResponseDto;
import com.abdulhalim.repository.DepartmentRepository;
import com.abdulhalim.repository.EmployeeRepository;
import com.abdulhalim.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final UniqueKeyConfiguration uniqueKeyConfiguration;

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeRequestDto employeeRequestDto) {

        String ff = uniqueKeyConfiguration.uuid().getUuid().toString();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDto,employee);
        Optional<Department> optionalDepartment = departmentRepository.findById(employeeRequestDto.getDepartmentId());
//        employee.setCode(ff);
        employee.setDepartment(optionalDepartment.get());
        employeeRepository.saveAndFlush(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EmployeeResponseDto> getAllEmployeeList() {
        List<EmployeeResponseDto> employeeResponseDtoList = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee employee: employeeList){

            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

            employeeResponseDto.setId(employee.getId());
            employeeResponseDto.setCode(employee.getCode());
            employeeResponseDto.setName(employee.getName());
            employeeResponseDto.setDob(employee.getDob());
            employeeResponseDto.setGender(employee.getGender());
            employeeResponseDto.setDepartment(employee.getDepartment());

            employeeResponseDtoList.add(employeeResponseDto);
        }
        return new ResponseEntity(employeeResponseDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateEmployee(Long employeeId,EmployeeRequestDto employeeRequestDto) {

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (!employeeOptional.isPresent()){
            throw new RuntimeException("Not found Employee");
        }

        Optional<Department> departmentOptional = departmentRepository.findById(employeeRequestDto.getDepartmentId());

        if (!departmentOptional.isPresent()){
            throw new RuntimeException("Not found Department");
        }
        Department department = departmentOptional.get();

        Employee employee = employeeOptional.get();

//        employee.setCode(uniqueKeyConfiguration.uuid().getUuid().toString());

        employee.setName(employeeRequestDto.getName());

        employee.setCode(employeeRequestDto.getCode());

        employee.setDob(employeeRequestDto.getDob());

        employee.setGender(employeeRequestDto.getGender());

        employee.setMobile(employeeRequestDto.getMobile());

        employee.setDepartment(department);

        employeeRepository.save(employee);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
