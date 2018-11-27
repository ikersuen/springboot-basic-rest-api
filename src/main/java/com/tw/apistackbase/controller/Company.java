package com.tw.apistackbase.controller;

import com.tw.apistackbase.Employee;

import java.lang.annotation.ElementType;
import java.util.List;

public class Company {
    private String name;
    private int id;
    private List<Employee> employees;

    public Company(int id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
