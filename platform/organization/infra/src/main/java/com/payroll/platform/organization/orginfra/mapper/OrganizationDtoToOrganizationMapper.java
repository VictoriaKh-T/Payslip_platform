package com.payroll.platform.organization.orginfra.mapper;

import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationResponse;
import com.payroll.platform.organization.orginfra.adapter.driven.persistence.entity.OrganizationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationDtoToOrganizationMapper {
  OrganizationDtoToOrganizationMapper INSTANCE =
      Mappers.getMapper(OrganizationDtoToOrganizationMapper.class);

  OrganizationEntity mapToEntity(OrganizationRequest request);

  OrganizationResponse mapToResponse(OrganizationEntity entity);

  UpdateOrganizationResponse mapToUpdateResponse(OrganizationEntity entity);
}
