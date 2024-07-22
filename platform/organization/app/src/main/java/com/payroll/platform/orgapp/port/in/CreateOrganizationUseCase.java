package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;

public interface CreateOrganizationUseCase {

  OrganizationResponse addOrganization(OrganizationRequest organizationRequest);
}
