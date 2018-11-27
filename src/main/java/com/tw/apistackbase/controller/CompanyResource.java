package com.tw.apistackbase.controller;

import java.util.List;

import com.tw.apistackbase.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyResource {


    private CompanyService companyService;

    @Autowired
    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Company>> getCompany() {
        List<Company> companies = companyService.getAll();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public Company getEmployeeById(@PathVariable int id) {

        return companyService.findById(id);
    }

    @PostMapping(produces = "application/json")
    public int addEmployee(@RequestBody Company company){
        return companyService.add(company);
    }
}
