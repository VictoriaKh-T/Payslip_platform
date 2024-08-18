package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.FindOrganizationByKodUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

@UseCase
public class FindOrganizationByKodService implements FindOrganizationByKodUseCase {
  private final OrganizationRepository organizationRepository;

  public FindOrganizationByKodService(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  @Override
  public OrganizationResponse findOrganizationByKodUseCase(String organization_kod) {
    return organizationRepository.findByOrganizationKod(organization_kod);
  }
}
