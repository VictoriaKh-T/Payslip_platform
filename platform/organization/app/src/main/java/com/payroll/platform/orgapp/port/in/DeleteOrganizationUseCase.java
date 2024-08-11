package com.payroll.platform.orgapp.port.in;

import com.payroll.platform.orgdomain.dto.OrganizationId;

public interface DeleteOrganizationUseCase {

    void deleteOrganizationById(OrganizationId organizationId);
}
