package com.abdulhalim.service.Implementation;

import com.abdulhalim.dto.EmployeeDto;
import com.abdulhalim.entity.Employee;
import com.abdulhalim.repository.EmployeeRepository;
import com.abdulhalim.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;

    @Override
    public Object saveEmployee(Employee employee) {
        Employee employee1 = employeeRepo.findEmployeeByCode(employee.getCode());

        if (employee1 == null){
            return employeeRepo.save(employee);
        }
        HashMap<String,String> dublicateMsg = new HashMap<>();
        dublicateMsg.put("code","Already exists of the code.Please try again...");
        return dublicateMsg;

    }

    @Override
    public Object updateEmployee(Employee employee) {
        Employee employee1 = employeeRepo.findEmployeeByCode(employee.getCode());

        if (employee1 == null){
            return employeeRepo.save(employee);
        }

        String codeExistId = employee1.getId().toString();
        String codeId = employee.getId().toString();
        if (codeExistId.equals(codeId)){
            return employeeRepo.save(employee);
        }
            HashMap<String,String> dublicateMsg = new HashMap<>();
            dublicateMsg.put("code","Already exists of the code.Please try again...");
            return dublicateMsg;
    }

    @Override
    public Object deleteEmployeeById(Long id) {
        HashMap<String,String> deleteMsg = new HashMap<>();
        try {
            Employee employee = employeeRepo.findById(id).get();
        }catch (NoSuchElementException e){
            deleteMsg.put("id: "+id,"Not Found");
            return deleteMsg;
        }
        employeeRepo.delete(employeeRepo.findById(id).get());
        deleteMsg.put("id: "+id,"Employee has been successfully deleted.");
        return deleteMsg;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id).get();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList;
    }

    @Override
    public List<EmployeeDto> findAllEmployee() {
        List<EmployeeDto> dtos = new ArrayList<>();
        this.employeeRepo.findAll().parallelStream().forEach((e)->{
            dtos.add(convertEntityToDto(e));
        });
        return dtos;
    }

    @Override
    public EmployeeDto convertEntityToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        BeanUtils.copyProperties(employee,dto);
        dto.setDepartmentName(employee.getDepartment().getDepartmentName());
        return dto;
    }
}
