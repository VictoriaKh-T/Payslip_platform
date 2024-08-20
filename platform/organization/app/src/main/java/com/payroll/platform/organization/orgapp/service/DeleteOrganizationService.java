package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.DeleteOrganizationUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.OrganizationId;

@UseCase
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
