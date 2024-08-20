package com.payroll.platform.organization.orginfra.adapter.driven.persistence.repository;

import com.payroll.platform.hexagonal.annotations.Adapter;
import com.payroll.platform.organization.orgapp.port.out.persistence.OrganizationRepository;
import com.payroll.platform.organization.orgdomain.dto.OrganizationId;
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
public class OrganizationAdapter implements OrganizationRepository {

  private final OrganizationPostgresRepository organizationPostgresRepository;
  private final OrganizationDtoToOrganizationMapper mapper =
      OrganizationDtoToOrganizationMapper.INSTANCE;

  @Override
  public OrganizationResponse addOrganization(OrganizationRequest organizationRequest) {
    OrganizationEntity organization =
        organizationPostgresRepository.save(mapper.mapToEntity(organizationRequest));
    return mapper.mapToResponse(organization);
  }

  @Override
  public OrganizationResponse findByOrganizationId(OrganizationId organizationId) {
    OrganizationEntity organization =
        organizationPostgresRepository
            .findById(organizationId.organizationId())
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by id" + organizationId.organizationId()));
    return mapper.mapToResponse(organization);
  }

  @Override
  public OrganizationResponse findByOrganizationKod(String organization_kod) {
    return mapper.mapToResponse(
        organizationPostgresRepository
            .findByKodOrganization(organization_kod)
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by kod" + organization_kod)));
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
  public void deleteOrganizationById(OrganizationId organizationId) {
    OrganizationEntity organization =
        organizationPostgresRepository
            .findById(organizationId.organizationId())
            .orElseThrow(
                () ->
                    new OrganizationNotFoundException(
                        "can`t find organization by id" + organizationId.organizationId()));
    organizationPostgresRepository.delete(organization);
  }

  @Override
  public List<OrganizationResponse> findAllOrganizations() {
    return organizationPostgresRepository.findAll().stream().map(mapper::mapToResponse).toList();
  }
}
