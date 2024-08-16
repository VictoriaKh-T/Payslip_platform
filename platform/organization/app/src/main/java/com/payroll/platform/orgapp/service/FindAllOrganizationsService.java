package com.payroll.platform.orgapp.service;

import com.payroll.platform.orgapp.port.in.FindAllOrganizationsUseCase;
import com.payroll.platform.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;

import java.util.List;

public class FindAllOrganizationsService implements FindAllOrganizationsUseCase {
    private final OrganizationRepository organizationRepository;

    public FindAllOrganizationsService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<OrganizationResponse> findAll() {
        return organizationRepository.findAllOrganizations();
    }
}
