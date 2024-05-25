package com.example.crud.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(1);
    }

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees(@RequestParam("order") Optional<String> order,
            @RequestParam("orderBy") Optional<String> orderBy) {
        return employeeService.getAllEmployee("", "");
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer createEmployee(@RequestBody Employee employee, Principal principal) {
        if (employee != null && !employee.getName().isEmpty()) {
            employeeService.createEmployee(employee);
            return employeeService.getLatestEmployeeId();
        }
        return 1;
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer updateEmployee(@PathVariable Integer id,
            @RequestBody Employee employee, Principal principal) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return id;
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEmployee(@PathVariable Integer id, Principal principal) {
        employeeService.deleteEmployee(id);
    }

}