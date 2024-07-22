package com.week2.APIs.springbootwebpractice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.week2.APIs.springbootwebpractice.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "name field can not be empty")
    @Size(min = 1, max = 16, message = "name has to be bw 1 and 16 characters")
    private String name;
    @NotNull(message = "age field can not be empty")
    @Max(value = 70, message = "age has to be between 18 and 70")
    @Min(value = 18, message = "age has to be between 18 and 70")
    private Integer age;
    private Long id;
    private LocalDate dateOfJoining;
    @NotBlank(message = "role field can not be empty")
    //@Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation
    private String role;
    @NotBlank(message = "email field can not be empty")
    @Email(message = "Please enter a valid email")
    private String email;
    @JsonProperty("isActive")
    private Boolean isActive;
}
