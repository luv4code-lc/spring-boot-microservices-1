package com.luv4code.departmentservice.client;

import com.luv4code.departmentservice.web.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/employee/department/{departmentId}")
    List<Employee> findByDepartment(@PathVariable Long departmentId);
}
