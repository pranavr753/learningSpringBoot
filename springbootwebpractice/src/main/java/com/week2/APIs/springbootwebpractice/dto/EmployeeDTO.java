package com.week2.APIs.springbootwebpractice.dto;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeDTO {
    String name;
    int age;
    Long id;
    LocalDate dateOfJoining;
    String email;

    public EmployeeDTO() {

    }

    public EmployeeDTO(String name, int age, Long id, LocalDate dateOfJoining, String email) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.dateOfJoining = dateOfJoining;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
