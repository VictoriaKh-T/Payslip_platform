package com.payroll.platform.orginfra.adapter.driven.persistence.repository;

import com.payroll.platform.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.orgdomain.dto.OrganizationId;
import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationResponse;

public class OrganizationAdapter implements OrganizationRepository {
  @Override
  public OrganizationResponse addOrganization(OrganizationRequest organization) {
    return null;
  }

  @Override
  public OrganizationResponse findByOrganizationId(OrganizationId organizationId) {
    return null;
  }

  @Override
  public OrganizationResponse findByOrganizationKod(String organization_kod) {
    return null;
  }

  @Override
  public UpdateOrganizationResponse updateOrganizationById(
      Long organization_Id, UpdateOrganizationRequest request) {
    return null;
  }

  @Override
  public void deleteOrganizationById(OrganizationId organizationId) {}
}
