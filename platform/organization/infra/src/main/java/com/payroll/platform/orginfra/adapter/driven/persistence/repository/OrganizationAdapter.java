package com.payroll.platform.orginfra.adapter.driven.persistence.repository;

import com.payroll.platform.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.orgdomain.dto.OrganizationId;
import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationResponse;
import com.payroll.platform.orginfra.adapter.driven.persistence.entity.OrganizationEntity;
import com.payroll.platform.orginfra.exeption.OrganizationNotFoundException;
import com.payroll.platform.orginfra.mapper.OrganizationDtoToOrganizationMapper;

import java.util.Optional;

public class OrganizationAdapter implements OrganizationRepository {

  private final PostgresOrganizationRepository postgresOrganizationRepository;
  private final OrganizationDtoToOrganizationMapper mapper;

  public OrganizationAdapter(PostgresOrganizationRepository postgresOrganizationRepository, OrganizationDtoToOrganizationMapper mapper) {
    this.postgresOrganizationRepository = postgresOrganizationRepository;
    this.mapper = mapper;
  }

  @Override
  public OrganizationResponse addOrganization(OrganizationRequest organizationRequest) {
    OrganizationEntity organization = postgresOrganizationRepository.save(mapper.mapToEntity(organizationRequest));
    return mapper.mapToResponse(organization);
  }

  @Override
  public OrganizationResponse findByOrganizationId(OrganizationId organizationId) {
    OrganizationEntity organization
            = postgresOrganizationRepository.findById(organizationId.organizationId()).orElseThrow( ()
                     -> new OrganizationNotFoundException("can`t find book by id" +
            organizationId.organizationId()));
    return mapper.mapToResponse(organization);
  }

  @Override
  public OrganizationResponse findByOrganizationKod(String organization_kod) {
    return null;
  }

  @Override
  public UpdateOrganizationResponse updateOrganizationById(
      Long organization_Id, UpdateOrganizationRequest request) {
    return null;
  }

  @Override
  public void deleteOrganizationById(OrganizationId organizationId) {}
}
