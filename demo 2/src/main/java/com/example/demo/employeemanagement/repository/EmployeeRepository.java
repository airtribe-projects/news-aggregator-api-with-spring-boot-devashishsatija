package com.example.demo.employeemanagement.repository;

import com.example.demo.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    List<Employee> findByDepartmentId(Long departmentId);
    @Query("SELECT e FROM Employee e WHERE e.projects IS EMPTY")
    List<Employee> findEmployeesWithoutProjects();
    @Query("Select * from employee")
    List<Employee> findAll();
}
