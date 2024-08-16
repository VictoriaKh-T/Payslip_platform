package com.payroll.platform.orgapp.port.out.persistence;

import com.payroll.platform.orgdomain.dto.OrganizationId;
import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationResponse;

import java.util.List;

public interface OrganizationRepository {
  OrganizationResponse addOrganization(OrganizationRequest organization);

  OrganizationResponse findByOrganizationId(OrganizationId organization_id);

  OrganizationResponse findByOrganizationKod(String organization_kod);

  UpdateOrganizationResponse updateOrganizationById(
      Long organization_Id, UpdateOrganizationRequest request);

  void deleteOrganizationById(OrganizationId organizationId);

  List<OrganizationResponse> findAllOrganizations();
}
