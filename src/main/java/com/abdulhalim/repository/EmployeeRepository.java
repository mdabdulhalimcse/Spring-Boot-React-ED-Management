package com.abdulhalim.repository;

import com.abdulhalim.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    void deleteById(Long id);
}
