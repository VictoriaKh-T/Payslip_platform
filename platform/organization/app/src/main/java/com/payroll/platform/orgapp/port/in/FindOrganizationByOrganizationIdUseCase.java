package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.OrganizationRequest;

public interface FindOrganizationByOrganizationIdUseCase {

  OrganizationRequest findOrganizationByIdUseCase(Long organization_id);
}
