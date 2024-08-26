package com.payroll.userapp.port.in;

import com.payroll.userdomain.dto.CreateUserRequest;
import com.payroll.userdomain.dto.CreateUserResponse;

public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUserRequest request);
}
