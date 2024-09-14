package com.payroll.platform.person.personinfra.mapper;

import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import com.payroll.platform.person.persondomain.dto.UpdatePersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonEntityToUpdateDtoMapper {

  PersonEntityToUpdateDtoMapper INSTANCE = Mappers.getMapper(PersonEntityToUpdateDtoMapper.class);

  UpdatePersonResponse mapToPersonUpdateResponse(PersonEntity entity);
}
