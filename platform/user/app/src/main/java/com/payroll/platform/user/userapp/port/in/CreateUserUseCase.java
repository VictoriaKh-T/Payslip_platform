package com.payroll.platform.user.userapp.port.in;

import com.payroll.platform.user.userdomain.dto.CreateUserRequest;
import com.payroll.platform.user.userdomain.dto.CreateUserResponse;

public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUserRequest request);
}
