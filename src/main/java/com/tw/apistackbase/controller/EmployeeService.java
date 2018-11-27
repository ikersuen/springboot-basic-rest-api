package com.tw.apistackbase.controller;

import com.tw.apistackbase.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees;
    private int idIndex = 0;

    public EmployeeService(){
        this.employees = new ArrayList<>();
    }

    public List<Employee> getAll() {
        return this.employees;
    }

    public int add(Employee employee){
        employee.setId(idIndex++);
        this.employees.add(employee);
        return idIndex;
    }

    public Employee findById(int id){
        for(Employee employee : this.employees){
            if(employee.getId() == (id)){
                return employee;
            }
        }
        return null;
    }
}

