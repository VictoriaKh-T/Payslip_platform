package com.payroll.userapp.port.in;

import com.payroll.userdomain.dto.UpdateUserRequest;
import com.payroll.userdomain.dto.UpdateUserResponse;

public interface UpdateUserUseCase {
    UpdateUserResponse updateUserById(Long id, UpdateUserRequest request);
}
