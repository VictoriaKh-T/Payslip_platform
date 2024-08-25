package com.payroll.userapp.port.in;

import com.payroll.userdomain.dto.UserResponse;

public interface FindUserByEmailUseCase {
    UserResponse findUserByEmail(String email);
}
