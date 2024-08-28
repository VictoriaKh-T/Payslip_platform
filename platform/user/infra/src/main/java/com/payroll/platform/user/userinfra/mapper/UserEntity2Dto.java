package com.payroll.platform.user.userinfra.mapper;

import com.payroll.platform.user.userdomain.dto.UserResponse;
import com.payroll.platform.user.userinfra.adapter.driven.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntity2Dto {

    UserEntity2Dto INSTANCE =
            Mappers.getMapper(UserEntity2Dto.class);

    UserResponse mapToUserResponse(UserEntity entity);
}
