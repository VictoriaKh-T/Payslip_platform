package com.payroll.platform.organization.orgapp.port.in;

import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationResponse;

public interface UpdateOrganizationByIdUseCase {
  UpdateOrganizationResponse updateOrganization(
      Long id, UpdateOrganizationRequest updateOrganizationRequest);
}
