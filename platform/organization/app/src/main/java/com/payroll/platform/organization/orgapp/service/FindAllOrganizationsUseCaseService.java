package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.FindAllOrganizationsUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationPersistencePort;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import java.util.List;

@UseCase
public class FindAllOrganizationsUseCaseService implements FindAllOrganizationsUseCase {
  private final OrganizationPersistencePort organizationPersistencePort;

  public FindAllOrganizationsUseCaseService(OrganizationPersistencePort organizationPersistencePort) {
    this.organizationPersistencePort = organizationPersistencePort;
  }

  @Override
  public List<OrganizationResponse> findAll() {
    return organizationPersistencePort.findAllOrganizations();
  }
}
