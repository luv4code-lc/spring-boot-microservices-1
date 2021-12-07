package com.luv4code.departmentservice.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Department {
    private Long id;
    private Long organizationId;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(Long organizationId, String name) {
        this.organizationId = organizationId;
        this.name = name;
    }
}
