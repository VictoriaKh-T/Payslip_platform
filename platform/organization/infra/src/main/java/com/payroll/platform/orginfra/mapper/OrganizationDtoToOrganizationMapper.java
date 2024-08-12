package com.payroll.platform.orginfra.mapper;

import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.orginfra.adapter.driven.persistence.entity.OrganizationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationDtoToOrganizationMapper {
  OrganizationDtoToOrganizationMapper INSTANCE =
      Mappers.getMapper(OrganizationDtoToOrganizationMapper.class);

  OrganizationEntity mapToEntity(OrganizationRequest request);

  OrganizationResponse mapToResponse(OrganizationEntity entity);
}
