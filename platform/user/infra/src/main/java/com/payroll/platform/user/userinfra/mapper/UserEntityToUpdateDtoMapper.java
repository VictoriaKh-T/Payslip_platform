package com.payroll.platform.user.userinfra.mapper;

import com.payroll.platform.user.userdomain.dto.UpdateUserResponse;
import com.payroll.platform.user.userinfra.adapter.driven.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityToUpdateDtoMapper {

  UserEntityToUpdateDtoMapper INSTANCE = Mappers.getMapper(UserEntityToUpdateDtoMapper.class);

  UpdateUserResponse mapToUserUpdateResponse(UserEntity entity);
}
