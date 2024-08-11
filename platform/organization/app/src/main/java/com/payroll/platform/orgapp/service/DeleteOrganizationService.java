package com.payroll.platform.orgapp.service;

import com.payroll.platform.orgapp.port.in.DeleteOrganizationUseCase;
import com.payroll.platform.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.orgdomain.dto.OrganizationId;

public class DeleteOrganizationService implements DeleteOrganizationUseCase {

    private final OrganizationRepository organizationRepository;

    public DeleteOrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public void deleteOrganizationById(OrganizationId organizationId) {
        organizationRepository.deleteOrganizationById(organizationId);
    }
}
