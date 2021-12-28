package com.abdulhalim.dto.request;

import com.abdulhalim.entity.Gender;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class EmployeeRequestDto {

    private Long id;

    @NotEmpty(message = "Name can not be empty!")
    @Size(min = 3, message = "At least 3 character required")
    @Size(max = 35, message = "Maximum 35 Character")
    private String name;

    @Size(max = 4, min = 4, message = "Code must be 4 character")
    private String code;

    private LocalDate dob;

    private Gender gender;

    @NotEmpty(message = "Mobile number can not be empty!")
    @Size(max = 35, message = "Maximum 14 digits")
    private String mobile;

    private Long departmentId;
}
