package com.payroll.platform.organization.orgapp.port.in;

import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

public interface FindOrganizationByKodUseCase {
  OrganizationResponse findOrganizationByKodUseCase(String organization_kod);
}
