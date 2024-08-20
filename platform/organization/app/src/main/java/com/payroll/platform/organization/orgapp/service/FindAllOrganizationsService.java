package com.payroll.platform.organization.orgapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.organization.orgapp.port.in.FindAllOrganizationsUseCase;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import java.util.List;

@UseCase
public class FindAllOrganizationsService implements FindAllOrganizationsUseCase {
  private final OrganizationRepository organizationRepository;

  public FindAllOrganizationsService(OrganizationRepository organizationRepository) {
    this.organizationRepository = organizationRepository;
  }

  @Override
  public List<OrganizationResponse> findAll() {
    return organizationRepository.findAllOrganizations();
  }
}
