package com.example.crud.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

    public Employee(String name, String dob, String department, Double salary) {
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.salary = salary;
    }

    private Integer id;
    private String name;
    private String dob;
    private String department;
    private Double salary;

}