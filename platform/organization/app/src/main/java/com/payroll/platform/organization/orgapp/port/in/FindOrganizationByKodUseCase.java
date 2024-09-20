package com.payroll.platform.organization.orgapp.port.in;

import com.payroll.platform.organization.orgdomain.dto.FindOrganizationByKodRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

public interface FindOrganizationByKodUseCase {
  OrganizationResponse findOrganizationByKodUseCase(FindOrganizationByKodRequest organizationKod);
}
