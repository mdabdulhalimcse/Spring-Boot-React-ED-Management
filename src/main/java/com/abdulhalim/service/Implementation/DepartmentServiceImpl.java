package com.abdulhalim.service.Implementation;

import com.abdulhalim.entity.Department;
import com.abdulhalim.dto.request.DepartmentRequestDto;
import com.abdulhalim.dto.response.DepartmentResponseDto;
import com.abdulhalim.entity.Employee;
import com.abdulhalim.repository.DepartmentRepository;
import com.abdulhalim.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    public final DepartmentRepository departmentRepository;


    @Override
    public ResponseEntity<Department> createDepartment(DepartmentRequestDto departmentRequestDto) {

        Department department = new Department();
        BeanUtils.copyProperties(departmentRequestDto,department);
        departmentRepository.saveAndFlush(department);

        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateDepartment(Long departmentId, DepartmentRequestDto departmentRequestDto) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);

        if (!optionalDepartment.isPresent()){
            throw new RuntimeException("Not found Employee");
        }

        Department department = optionalDepartment.get();

        department.setDepartmentName(departmentRequestDto.getDepartmentName());

        department.setActive(departmentRequestDto.isActive());

        departmentRepository.save(department);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<DepartmentResponseDto> getAllDepartmentList() {

        List<DepartmentResponseDto> departmentResponseDtoArrayList = new ArrayList<>();

        List<Department> departmentList = departmentRepository.findAll();

        for (Department department: departmentList){

            DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();

            departmentResponseDto.setId(department.getId());
            departmentResponseDto.setDepartmentName(department.getDepartmentName());
            departmentResponseDto.setActive(department.isActive());

            departmentResponseDtoArrayList.add(departmentResponseDto);
        }


        return new ResponseEntity(departmentResponseDtoArrayList,HttpStatus.OK);

    }

    @Override
    public DepartmentResponseDto getDepartmentBy(Long id) {
//        Optional<Department> departmentOptional = departmentRepository.findById(id);
//
//        Department department = departmentOptional.get();
//        return DepartmentResponseDto.builder()
//                .id(department.getId())
//                .departmentName(department.getDepartmentName())
//                .active(department.isActive())
//                .build();
        return null;
    }

}
