package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.FindOrganizationByOrganizationIdUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.OrganizationId;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

@UseCase
public class FindOrganizationByIdService implements FindOrganizationByOrganizationIdUseCase {

  private final OrganizationRepository organizationRepository;

  public FindOrganizationByIdService(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  @Override
  public OrganizationResponse findOrganizationByIdUseCase(Long id) {
    OrganizationId organizationId = new OrganizationId(id);
    return organizationRepository.findByOrganizationId(organizationId);
  }
}
