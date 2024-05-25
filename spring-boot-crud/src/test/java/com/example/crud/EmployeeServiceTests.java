package com.example.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeService;

@SpringBootTest
@Transactional
class EmployeeServiceTests {

    @Autowired
    EmployeeService employeeService;

    @Test
    void getEmployeeByIdTest() {

        Employee employee = employeeService.getEmployeeById(1);
        assertEquals("Merby", employee.getName());
    }

    @Test
    void getAllEmployeeTest() {

        List<Employee> Employee = employeeService.getAllEmployee("", "");
        Employee.forEach(u -> System.out.println("Employee ->" + u.getName()));
        assertTrue(!Employee.isEmpty());
    }

    @Test
    @Rollback(false)
    void createEmployeeTest() {

        String name = "Test Name";
        Employee employee = new Employee(name, "1990-01-01", "IT", 75000.0);
        employeeService.createEmployee(employee);

        Employee savedEmployee = employeeService.getEmployeeById(employee.getId());
        assertEquals(name, savedEmployee.getName());
    }

    @Test
    @Rollback(false)
    void updateEmployeeTest() {

        String newName = "New Name";
        Integer id = 9;
        Employee employee = new Employee(newName, "1990-01-21", "IT", 75000.0);
        employee.setId(id);
        employeeService.updateEmployee(employee);

        Employee updatedEmployee = employeeService.getEmployeeById(employee.getId());
        assertEquals(newName, updatedEmployee.getName());
    }

    @Test
    @Rollback(false)
    void deleteEmployeeTest() {

        Integer id = 14;
        employeeService.deleteEmployee(id);
        Employee deletedEmployee = employeeService.getEmployeeById(id);
        assertNull(deletedEmployee, "Employee should be null after deletion");
    }

}
