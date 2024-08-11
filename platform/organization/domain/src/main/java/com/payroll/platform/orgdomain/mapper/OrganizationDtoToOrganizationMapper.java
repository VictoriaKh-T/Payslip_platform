package com.payroll.platform.orgdomain.mapper;

import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationDtoToOrganizationMapper {
  OrganizationDtoToOrganizationMapper INSTANCE =
      Mappers.getMapper(OrganizationDtoToOrganizationMapper.class);

  OrganizationRequest toOrganizationResponse(UpdateOrganizationRequest organizationRequest);

  UpdateOrganizationResponse toUpdateResponse(OrganizationRequest organizationRequest);
}
