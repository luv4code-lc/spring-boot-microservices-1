package com.luv4code.organizationservice.repositories;

import com.luv4code.organizationservice.web.model.Organization;

import java.util.ArrayList;
import java.util.List;

public class OrganizationRepository {
    public List<Organization> organizations = new ArrayList<>();

    public Organization add(Organization organization) {
        organization.setId((long) organizations.size() + 1);
        organizations.add(organization);
        return organization;
    }

    public Organization findById(Long id) {
        return organizations.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Organization> findAll() {
        return organizations;
    }
}
