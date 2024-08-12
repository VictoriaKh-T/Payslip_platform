package com.payroll.platform.orgapp.service;

import com.payroll.platform.orgapp.port.in.UpdateOrganizationByIdUseCase;
import com.payroll.platform.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationResponse;

public class UpdateOrganizationService implements UpdateOrganizationByIdUseCase {
  private final OrganizationRepository organizationRepository;

  public UpdateOrganizationService(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  @Override
  public UpdateOrganizationResponse updateOrganization(
      Long id, UpdateOrganizationRequest updateOrganizationRequest) {
    return organizationRepository.updateOrganizationById(id, updateOrganizationRequest);
  }
}
