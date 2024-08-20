package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.UpdateOrganizationByIdUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationResponse;

@UseCase
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
