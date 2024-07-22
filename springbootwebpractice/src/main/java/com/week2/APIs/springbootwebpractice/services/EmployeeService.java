package com.week2.APIs.springbootwebpractice.services;

import com.week2.APIs.springbootwebpractice.dto.EmployeeDTO;
import com.week2.APIs.springbootwebpractice.entites.EmployeeEntity;
import com.week2.APIs.springbootwebpractice.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmpById(Long employeeId) {
        //we will transform from entity to dto and from controller we'll return dto
//        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
//        return modelMapper.map(employeeEntity, EmployeeDTO.class);
        return employeeRepository.findById(employeeId) //this is an optional+employeeEntity class, gotta change it  to empDTO
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> allEmp = employeeRepository.findAll();
        return allEmp
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO addEmployee(EmployeeDTO emp) {
        EmployeeEntity toSaveEntity = modelMapper.map(emp, EmployeeEntity.class);
        EmployeeEntity addedEmp = employeeRepository.save(toSaveEntity);
        return modelMapper.map(addedEmp, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long id) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        System.out.println(employeeRepository.existsById(id));
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean deleteEmployeeById(Long id) {
        if(!employeeRepository.existsById(id)) return false;
        employeeRepository.deleteById(id);
        return true;
    }

    public EmployeeDTO updateFewFields(Map<String, Object> employeeDetails, Long employeeId) {
        System.out.println(EmployeeEntity.class.toString());
        if(!employeeRepository.existsById(employeeId)) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        employeeDetails.forEach((field, value)->{
            Field fieldToUpdate = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
