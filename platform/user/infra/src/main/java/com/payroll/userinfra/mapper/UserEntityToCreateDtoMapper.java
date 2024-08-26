package com.payroll.userinfra.mapper;

import com.payroll.userdomain.dto.CreateUserRequest;
import com.payroll.userdomain.dto.CreateUserResponse;
import com.payroll.userdomain.dto.UpdateUserResponse;
import com.payroll.userinfra.adapter.driven.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityToCreateDtoMapper {

    UserEntityToCreateDtoMapper INSTANCE =
            Mappers.getMapper(UserEntityToCreateDtoMapper.class);

    UserEntity mapToEntity(CreateUserRequest request);
    CreateUserResponse mapToCreateResponse(UserEntity entity);


}
