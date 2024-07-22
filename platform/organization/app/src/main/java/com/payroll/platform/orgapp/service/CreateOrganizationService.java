package com.payroll.platform.orgapp.service;

import com.payroll.platform.orgapp.port.in.CreateOrganizationUseCase;
import com.payroll.platform.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;

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
