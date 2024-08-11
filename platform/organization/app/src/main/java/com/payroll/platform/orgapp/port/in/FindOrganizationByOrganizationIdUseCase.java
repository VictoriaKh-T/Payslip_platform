package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.OrganizationResponse;

public interface FindOrganizationByOrganizationIdUseCase {

  OrganizationResponse findOrganizationByIdUseCase(Long organization_id);
}
