
package com.example.demo.employeemanagement.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects;
}
