package com.abdulhalim.dto.response;

import com.abdulhalim.entity.Department;
import com.abdulhalim.entity.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeResponseDto {

    private Long id;

    private String code;

    private String name;

    private LocalDate dob;

    private Gender gender;

    private String mobile;

    private Department department;
}
