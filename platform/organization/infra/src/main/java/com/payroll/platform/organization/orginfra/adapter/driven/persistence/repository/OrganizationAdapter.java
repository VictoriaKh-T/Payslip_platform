package com.payroll.platform.organization.orginfra.adapter.driven.persistence.repository;

import com.payroll.platform.hexagonal.annotations.Adapter;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationPersistencePort;
import com.payroll.platform.organization.orgdomain.dto.FindOrganizationByKodRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationResponse;
import com.payroll.platform.organization.orginfra.adapter.driven.persistence.entity.OrganizationEntity;
import com.payroll.platform.organization.orginfra.exeption.OrganizationNotFoundException;
import com.payroll.platform.organization.orginfra.mapper.OrganizationDtoToOrganizationMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class OrganizationAdapter implements OrganizationPersistencePort {

  private final OrganizationPostgresRepository organizationPostgresRepository;
  private final OrganizationDtoToOrganizationMapper mapper =
      OrganizationDtoToOrganizationMapper.INSTANCE;

  @Override
  public OrganizationResponse createOrganization(OrganizationRequest organizationRequest) {
    OrganizationEntity organization =
        organizationPostgresRepository.save(mapper.mapToEntity(organizationRequest));
    return mapper.mapToResponse(organization);
  }

  @Override
  public OrganizationResponse findByOrganizationId(Long organizationId) {
    OrganizationEntity organization =
        organizationPostgresRepository
            .findById(organizationId)
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by id " + organizationId));
    return mapper.mapToResponse(organization);
  }

  @Override
  public OrganizationResponse findByOrganizationKod(FindOrganizationByKodRequest organizationKod) {
    return mapper.mapToResponse(
        organizationPostgresRepository
            .findByKodOrganization(organizationKod.organizationKod())
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by kod" + organizationKod.organizationKod())));
  }

  @Override
  public UpdateOrganizationResponse updateOrganizationById(
      Long organization_Id, UpdateOrganizationRequest request) {
    OrganizationEntity organization =
        organizationPostgresRepository
            .findById(organization_Id)
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by id" + organization_Id));
    organization.setKodOrganization(request.kodOrganization());
    organization.setName(request.name());
    organization.setAddress(request.address());
    organizationPostgresRepository.save(organization);
    return mapper.mapToUpdateResponse(organization);
  }

  @Override
  public void deleteOrganizationById(Long organizationId) {
    organizationPostgresRepository.deleteById(organizationId);
  }

  @Override
  public List<OrganizationResponse> findAllOrganizations() {
    return organizationPostgresRepository.findAll().stream().map(mapper::mapToResponse).toList();
  }
}
