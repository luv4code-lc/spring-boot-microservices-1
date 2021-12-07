package com.luv4code.organizationservice.client;

import com.luv4code.organizationservice.web.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "department-service")
public interface DepartmentClient {

    @GetMapping("/department/organization/{organizationId}")
    List<Department> findByOrganization(@PathVariable Long organizationId);

    @GetMapping("/department/organization/{organizationId}/with-employees")
    List<Department> findByOrganizationWithEmployees(@PathVariable Long organizationId);
}
