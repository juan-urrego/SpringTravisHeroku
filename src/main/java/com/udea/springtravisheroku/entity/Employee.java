package com.udea.springtravisheroku.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(name = "emp_salary", nullable = false)
    private long salary;

    @Column(name = "emp_role", nullable = false)
    private String role;

    @Column(name = "emp_address", nullable = false)
    private String address;

    @Column(name = "emp_office", nullable = false)
    private String office;

    @Column(name = "emp_branch", nullable = false)
    private String branch;

    @Column(name = "emp_email", nullable = false, unique = true)
    private String email;

    @Column(name = "emp_phone", nullable = false)
    private String phone;

    public Employee(String name, long salary, String role, String address, String office, String branch, String email, String phone) {
        this.name = name;
        this.salary = salary;
        this.role = role;
        this.address = address;
        this.office = office;
        this.branch = branch;
        this.email = email;
        this.phone = phone;
    }
}
