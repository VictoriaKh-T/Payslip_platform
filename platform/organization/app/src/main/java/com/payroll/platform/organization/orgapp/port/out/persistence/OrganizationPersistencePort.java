package com.payroll.platform.organization.orgapp.port.out.persistence;

import com.payroll.platform.organization.orgdomain.dto.FindOrganizationByKodRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationResponse;
import java.util.List;

public interface OrganizationPersistencePort {
  OrganizationResponse createOrganization(OrganizationRequest organization);

  OrganizationResponse findByOrganizationId(Long organizationId);

  OrganizationResponse findByOrganizationKod(FindOrganizationByKodRequest organizationKod);

  UpdateOrganizationResponse updateOrganizationById(
      Long organization_Id, UpdateOrganizationRequest request);

  void deleteOrganizationById(Long organizationId);

  List<OrganizationResponse> findAllOrganizations();
}
