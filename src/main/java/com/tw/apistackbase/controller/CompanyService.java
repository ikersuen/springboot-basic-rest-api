package com.tw.apistackbase.controller;

import com.tw.apistackbase.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private List<Company> companies;
    private int idIndex = 1;

    public CompanyService(){
        this.companies = new ArrayList<>();
    }

    public List<Company> getAll() {
        return this.companies;
    }

    public int add(Company company){
        company.setId(idIndex++);
        this.companies.add(company);
        return company.getId();
    }

    public Company findById(int id){
        for(Company company : this.companies){
            if(company.getId() == (id)){
                return company;
            }
        }
        return null;
    }

    public void deleteById(int id){
        for(Company company : this.companies){
            if(company.getId() == (id)){
                this.companies.remove(company);
            }
        }
    }
}

