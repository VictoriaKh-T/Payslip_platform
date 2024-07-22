package com.payroll.platform.orgapp.port.out.persistence;

import com.payroll.platform.orgdomain.dto.OrganizationId;
import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;

import java.util.Optional;

public interface OrganizationRepository {
    void save(OrganizationRequest organization);

    OrganizationResponse findByOrganizationId(OrganizationId organization_id);

    OrganizationResponse findByOrganizationKod(String organization_kod);

    void deleteOrganizationById(OrganizationId organizationId);

}
