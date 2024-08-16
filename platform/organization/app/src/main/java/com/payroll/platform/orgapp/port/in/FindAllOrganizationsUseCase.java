package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.OrganizationResponse;

import java.util.List;

public interface FindAllOrganizationsUseCase {
   List<OrganizationResponse> findAll();
}
