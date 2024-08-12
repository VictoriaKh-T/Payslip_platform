package com.payroll.platform.orginfra.adapter.driven.persistence.repository;

import com.payroll.platform.orginfra.adapter.driven.persistence.entity.OrganizationEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PostgresOrganizationRepository extends JpaRepository<OrganizationEntity, Long> {

  Optional<OrganizationEntity> findByKodOrganization(
      @Param("organizationId") String organizationId);
}
