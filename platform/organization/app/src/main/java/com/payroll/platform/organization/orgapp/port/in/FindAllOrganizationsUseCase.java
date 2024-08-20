package com.payroll.platform.organization.orgapp.port.in;

import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import java.util.List;

public interface FindAllOrganizationsUseCase {
  List<OrganizationResponse> findAll();
}
