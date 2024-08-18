package com.payroll.platform.organization.orgapp.port.in;

import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;

public interface CreateOrganizationUseCase {

  OrganizationResponse addOrganization(OrganizationRequest organizationRequest);
}
