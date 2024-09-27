package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.FindOrganizationByKodUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationPersistencePort;
import com.payroll.platform.organization.orgdomain.dto.FindOrganizationByKodRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

@UseCase
public class FindOrganizationByKodUseCaseService implements FindOrganizationByKodUseCase {
  private final OrganizationPersistencePort organizationPersistencePort;

  public FindOrganizationByKodUseCaseService(OrganizationPersistencePort organizationPersistencePort) {
    this.organizationPersistencePort = organizationPersistencePort;
  }

  @Override
  public OrganizationResponse findOrganizationByKodUseCase(
      FindOrganizationByKodRequest organizationKod) {
    return organizationPersistencePort.findByOrganizationKod(organizationKod);
  }
}
