package com.payroll.platform.user.userapp.port.in;

import com.payroll.platform.user.userdomain.dto.UpdateUserRequest;
import com.payroll.platform.user.userdomain.dto.UpdateUserResponse;

public interface UpdateUserUseCase {
    UpdateUserResponse updateUserById(Long id, UpdateUserRequest request);
}
