package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.OrganizationRequest;

public interface FindOrganizationByKodUseCase {
  OrganizationRequest findOrganizationByKodUseCase(String organization_kod);
}
