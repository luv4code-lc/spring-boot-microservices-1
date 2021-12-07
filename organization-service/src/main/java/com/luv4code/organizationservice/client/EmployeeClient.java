package com.luv4code.organizationservice.client;

import com.luv4code.organizationservice.web.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/employee/organization/{organizationId}")
    List<Employee> findByOrganization(@PathVariable Long organizationId);
}
