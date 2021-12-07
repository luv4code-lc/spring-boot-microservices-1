package com.luv4code.employeeservice.repository;

import com.luv4code.employeeservice.web.model.Employee;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.util.Assert;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeRepositoryTest {

    private static final EmployeeRepository repository = new EmployeeRepository();

    @Test
    @Order(1)
    void testAddEmployee() {
        Employee employee = new Employee(1L, 1L, "Test test", 100, "Test");
        employee = repository.add(employee);
        Assert.notNull(employee, "Employee is not null.");
        Assert.isTrue(employee.getId() == 1L, "Employee Bad id.");
    }


}