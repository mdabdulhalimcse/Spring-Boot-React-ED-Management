package com.abdulhalim.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class DepartmentRequestDto {

    private Long id;

    @NotEmpty(message = "Name can not be empty!")
    @Size(min = 3,message = "At least 3 character required")
    @Size(max = 35,message = "Maximum 35 Character")
    private String departmentName;

    private boolean active;
}
