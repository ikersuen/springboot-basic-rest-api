package com.tw.apistackbase.controller;

import java.util.List;

import com.tw.apistackbase.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> getEmployee(@RequestParam(value = "gender", required = false) String gender,
                                                      @RequestParam(value = "page", required = false) int page,
                                                      @RequestParam(value = "pageSize", required = false) int pageSize
                                                      ) {
        if(gender != null){
            return ResponseEntity.ok(employeeService.findByGender(gender));
        }

        List<Employee> employees = employeeService.getAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        return employeeService.findById(id);
    }

    @PostMapping(produces = "application/json")
    public int addEmployee(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @PutMapping("/{id}")
    public @ResponseBody String updateEmployee(@PathVariable int id, @RequestBody Employee employeeUpdate){
        if(employeeService.findById(id) != null){
            Employee update = employeeService.findById(id);
            update.setAge(employeeUpdate.getAge());
            update.setGender(employeeUpdate.getGender());
            update.setName(employeeUpdate.getName());
            return "update success";
        }else{
            return "update failed";
        }
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
    }
}
