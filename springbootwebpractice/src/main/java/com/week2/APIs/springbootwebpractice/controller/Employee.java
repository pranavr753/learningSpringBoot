package com.week2.APIs.springbootwebpractice.controller;

import com.week2.APIs.springbootwebpractice.dto.EmployeeDTO;
import com.week2.APIs.springbootwebpractice.entites.EmployeeEntity;
import com.week2.APIs.springbootwebpractice.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class Employee {

    private final EmployeeService employeeService;
    public Employee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmpById(@PathVariable Long employeeId) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmpById(employeeId);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) String age,
                                       @RequestParam(required = false) String name) {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeDTO emp) {
         EmployeeDTO savedEmp = employeeService.addEmployee(emp);
         return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable(name = "employeeId") Long id) {
        return employeeService.updateEmployeeById(employeeDTO, id);
    }

    @DeleteMapping(path="/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updateFewFields(@RequestBody Map<String, Object> employeeDetails, @PathVariable Long employeeId) {
        return employeeService.updateFewFields(employeeDetails, employeeId);
    }
}
