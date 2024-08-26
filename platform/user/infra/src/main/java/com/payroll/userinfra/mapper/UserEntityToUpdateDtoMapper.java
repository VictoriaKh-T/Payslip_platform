package com.payroll.userinfra.mapper;

import com.payroll.userdomain.dto.UpdateUserResponse;
import com.payroll.userinfra.adapter.driven.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityToUpdateDtoMapper {

    UserEntityToUpdateDtoMapper INSTANCE =
            Mappers.getMapper(UserEntityToUpdateDtoMapper.class);

    UpdateUserResponse mapToUserUpdateResponse(UserEntity entity);
}
