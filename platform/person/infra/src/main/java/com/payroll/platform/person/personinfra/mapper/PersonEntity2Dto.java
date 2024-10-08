package com.payroll.platform.person.personinfra.mapper;

import com.payroll.platform.person.persondomain.dto.PersonResponse;
import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonEntity2Dto {

  PersonEntity2Dto INSTANCE = Mappers.getMapper(PersonEntity2Dto.class);

  PersonResponse mapToPersonResponse(PersonEntity entity);
}
