package com.payroll.platform.organization.orgapp.port.in;

import com.payroll.platform.organization.orgdomain.dto.OrganizationId;

public interface DeleteOrganizationUseCase {

  void deleteOrganizationById(OrganizationId organizationId);
}
