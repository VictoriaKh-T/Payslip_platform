package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.CreateOrganizationUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

@UseCase
public class CreateOrganizationService implements CreateOrganizationUseCase {

  private final OrganizationRepository organizationRepository;

  public CreateOrganizationService(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  @Override
  public OrganizationResponse addOrganization(OrganizationRequest request) {
    return organizationRepository.addOrganization(request);
  }
}
