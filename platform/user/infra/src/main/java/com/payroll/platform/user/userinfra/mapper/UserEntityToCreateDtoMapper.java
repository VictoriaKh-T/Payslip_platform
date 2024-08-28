package com.payroll.platform.user.userinfra.mapper;

import com.payroll.platform.user.userdomain.dto.CreateUserRequest;
import com.payroll.platform.user.userdomain.dto.CreateUserResponse;
import com.payroll.platform.user.userinfra.adapter.driven.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityToCreateDtoMapper {

    UserEntityToCreateDtoMapper INSTANCE =
            Mappers.getMapper(UserEntityToCreateDtoMapper.class);

    UserEntity mapToEntity(CreateUserRequest request);
    CreateUserResponse mapToCreateResponse(UserEntity entity);


}
