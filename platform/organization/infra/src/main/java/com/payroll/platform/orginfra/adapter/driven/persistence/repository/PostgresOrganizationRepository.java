package com.payroll.platform.orginfra.adapter.driven.persistence.repository;

import com.payroll.platform.orginfra.adapter.driven.persistence.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresOrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
}
