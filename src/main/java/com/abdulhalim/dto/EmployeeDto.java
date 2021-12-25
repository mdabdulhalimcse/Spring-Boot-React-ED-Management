package com.abdulhalim.dto;

import com.abdulhalim.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {

    private Long id;

    private String code;

    private String name;

    private LocalDate dob;

    private Gender gender;

    private String mobile;

    private String departmentName;
}
