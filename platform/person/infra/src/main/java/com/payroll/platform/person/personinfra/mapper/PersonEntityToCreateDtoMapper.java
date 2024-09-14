package com.payroll.platform.person.personinfra.mapper;

import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;
import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonEntityToCreateDtoMapper {

  PersonEntityToCreateDtoMapper INSTANCE = Mappers.getMapper(PersonEntityToCreateDtoMapper.class);

  PersonEntity mapToEntity(CreatePersonRequest request);

  CreatePersonResponse mapToCreateResponse(PersonEntity entity);
}
