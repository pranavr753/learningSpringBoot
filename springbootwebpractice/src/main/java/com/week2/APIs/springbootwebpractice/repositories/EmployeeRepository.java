package com.week2.APIs.springbootwebpractice.repositories;

import com.week2.APIs.springbootwebpractice.entites.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
