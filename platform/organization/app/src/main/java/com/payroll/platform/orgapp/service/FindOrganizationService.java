package com.payroll.platform.orgapp.service;

import com.payroll.platform.orgapp.port.in.FindOrganizationByKodUseCase;
import com.payroll.platform.orgapp.port.in.FindOrganizationByOrganizationIdUseCase;
import com.payroll.platform.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.orgdomain.dto.OrganizationId;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;

public class FindOrganizationService
    implements FindOrganizationByKodUseCase, FindOrganizationByOrganizationIdUseCase {

  private final OrganizationRepository organizationRepository;

  public FindOrganizationService(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  @Override
  public OrganizationResponse findOrganizationByKodUseCase(String organization_kod) {
    return organizationRepository.findByOrganizationKod(organization_kod);
  }

  @Override
  public OrganizationResponse findOrganizationByIdUseCase(Long id) {
    OrganizationId organizationId = new OrganizationId(id);
    return organizationRepository.findByOrganizationId(organizationId);
  }
}
