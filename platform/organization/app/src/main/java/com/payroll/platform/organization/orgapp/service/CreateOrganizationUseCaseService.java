package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.CreateOrganizationUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationPersistencePort;
import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

@UseCase
public class CreateOrganizationUseCaseService implements CreateOrganizationUseCase {

  private final OrganizationPersistencePort organizationPersistencePort;

  public CreateOrganizationUseCaseService(OrganizationPersistencePort organizationPersistencePort) {
    this.organizationPersistencePort = organizationPersistencePort;
  }

  @Override
  public OrganizationResponse addOrganization(OrganizationRequest request) {
    return organizationPersistencePort.createOrganization(request);
  }
}
