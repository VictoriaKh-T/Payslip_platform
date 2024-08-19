package com.payroll.platform.organization.orginfra.adapter.driven.persistence.repository;

import com.payroll.platform.organization.orginfra.adapter.driven.persistence.entity.OrganizationEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationPostgresRepository extends JpaRepository<OrganizationEntity, Long> {

  @Query("FROM OrganizationEntity o WHERE o.kodOrganization = ?1 ")
  Optional<OrganizationEntity> findByKodOrganization(String organizationKod);
}
