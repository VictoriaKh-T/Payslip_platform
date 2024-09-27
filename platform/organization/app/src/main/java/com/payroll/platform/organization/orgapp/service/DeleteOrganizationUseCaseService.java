package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.DeleteOrganizationUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationPersistencePort;

@UseCase
public class DeleteOrganizationUseCaseService implements DeleteOrganizationUseCase {

  private final OrganizationPersistencePort organizationPersistencePort;

  public DeleteOrganizationUseCaseService(OrganizationPersistencePort organizationPersistencePort) {
    this.organizationPersistencePort = organizationPersistencePort;
  }

  @Override
  public void deleteOrganizationById(Long organizationId) {
    organizationPersistencePort.deleteOrganizationById(organizationId);
  }
}
