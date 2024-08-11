package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.OrganizationResponse;

public interface FindOrganizationByKodUseCase {
  OrganizationResponse findOrganizationByKodUseCase(String organization_kod);
}
