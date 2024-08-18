package com.payroll.platform.organization.orgapp.port.in;

import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

public interface FindOrganizationByOrganizationIdUseCase {

  OrganizationResponse findOrganizationByIdUseCase(Long organization_id);
}
