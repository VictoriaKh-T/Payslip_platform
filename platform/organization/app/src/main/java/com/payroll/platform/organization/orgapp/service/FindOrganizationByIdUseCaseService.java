package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.FindOrganizationByOrganizationIdUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationPersistencePort;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

@UseCase
public class FindOrganizationByIdUseCaseService implements FindOrganizationByOrganizationIdUseCase {

  private final OrganizationPersistencePort organizationPersistencePort;

  public FindOrganizationByIdUseCaseService(OrganizationPersistencePort organizationPersistencePort) {
    this.organizationPersistencePort = organizationPersistencePort;
  }

  @Override
  public OrganizationResponse findOrganizationByIdUseCase(Long organizationId) {
    return organizationPersistencePort.findByOrganizationId(organizationId);
  }
}
