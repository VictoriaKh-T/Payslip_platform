package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationResponse;

public interface UpdateOrganizationUseCase {
  UpdateOrganizationResponse updateOrganization(
      UpdateOrganizationRequest updateOrganizationRequest);
}
