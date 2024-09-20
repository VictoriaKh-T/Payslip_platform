package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.DeleteOrganizationUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;

@UseCase
public class DeleteOrganizationService implements DeleteOrganizationUseCase {

  private final OrganizationRepository organizationRepository;

  public DeleteOrganizationService(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  @Override
  public void deleteOrganizationById(Long organizationId) {
    organizationRepository.deleteOrganizationById(organizationId);
  }
}
