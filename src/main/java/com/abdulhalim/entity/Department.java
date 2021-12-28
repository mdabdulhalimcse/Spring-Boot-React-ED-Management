package com.abdulhalim.entity;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    private boolean active;


}
