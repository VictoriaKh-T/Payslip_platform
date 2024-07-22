package com.payroll.platform.orginfra.adapter.driven.persistence.repository;

import com.payroll.platform.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.orgdomain.dto.OrganizationId;
import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;

public class OrganizationAdapter  implements OrganizationRepository {
    @Override
    public void save(OrganizationRequest organization) {

    }

    @Override
    public OrganizationResponse findByOrganizationId(OrganizationId organization_id) {
        return null;
    }

    @Override
    public OrganizationResponse findByOrganizationKod(String organization_kod) {
        return null;
    }

    @Override
    public void deleteOrganizationById(OrganizationId organizationId) {

    }
}
