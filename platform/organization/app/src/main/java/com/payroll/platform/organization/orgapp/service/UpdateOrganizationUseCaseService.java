package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.UpdateOrganizationByIdUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationPersistencePort;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationResponse;

@UseCase
public class UpdateOrganizationUseCaseService implements UpdateOrganizationByIdUseCase {
  private final OrganizationPersistencePort organizationPersistencePort;

  public UpdateOrganizationUseCaseService(OrganizationPersistencePort organizationPersistencePort) {
    this.organizationPersistencePort = organizationPersistencePort;
  }

  @Override
  public UpdateOrganizationResponse updateOrganization(
      Long id, UpdateOrganizationRequest updateOrganizationRequest) {
    return organizationPersistencePort.updateOrganizationById(id, updateOrganizationRequest);
  }
}
