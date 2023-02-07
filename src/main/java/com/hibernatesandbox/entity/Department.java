package com.hibernatesandbox.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_Salary")
    private int minSalary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department_id")
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployeeToDepartment(Employee employee) {
        if (this.employees == null) {
            this.employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department() {

    }

    public Department(String name, int maxSalary, int minSalary) {
        this.name = name;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }


}
