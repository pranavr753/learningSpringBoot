package com.week2.APIs.springbootwebpractice.controller;

import com.week2.APIs.springbootwebpractice.dto.EmployeeDTO;
import com.week2.APIs.springbootwebpractice.entites.EmployeeEntity;
import com.week2.APIs.springbootwebpractice.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class Employee {

    private final EmployeeRepository employeeRepository;
    public Employee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getId(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAll(@RequestParam(required = false) String age,
                                       @RequestParam(required = false) String name) {
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity emp) {
         return employeeRepository.save(emp);
    }
}
