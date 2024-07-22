package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.OrganizationRequest;

public interface CreateOrganizationUseCase {

    OrganizationRequest addOrganization (String kodOrganization, String name, String contact, String address);
}
