package com.luv4code.departmentservice.web.controller;

import com.luv4code.departmentservice.client.EmployeeClient;
import com.luv4code.departmentservice.repositories.DepartmentRepository;
import com.luv4code.departmentservice.web.model.Department;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    private final DepartmentRepository repository;
    private final EmployeeClient client;

    @PostMapping("/")
    public Department createDepartment(@RequestBody Department department) {
        log.info("Department add: {}", department);
        return repository.add(department);
    }

    @GetMapping("/{id}")
    public Department findByDepartmentId(@PathVariable Long id) {
        log.info("Department find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/")
    public List<Department> findAllDepartments() {
        log.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganization(@PathVariable Long organizationId) {
        log.info("Department find: OrganizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable Long organizationId) {
        log.info("Department find: organizationId={}", organizationId);
        List<Department> departments = repository.findByOrganization(organizationId);
        departments.forEach(d -> d.setEmployees(client.findByDepartment(d.getId())));
        return departments;
    }
}
