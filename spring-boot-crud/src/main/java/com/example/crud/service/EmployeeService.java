package com.example.crud.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.mapper.EmployeeMapper;
import com.example.crud.model.Employee;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }

    public List<Employee> getAllEmployee(String orderBy, String order) {
        return employeeMapper.getAllEmployee(orderBy, order);
    }

    public Integer getLatestEmployeeId() {
        return employeeMapper.getLatestEmployeeId();
    }

    public void createEmployee(Employee employee) {
        employeeMapper.createEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeMapper.deleteEmployee(id);
    }

}
