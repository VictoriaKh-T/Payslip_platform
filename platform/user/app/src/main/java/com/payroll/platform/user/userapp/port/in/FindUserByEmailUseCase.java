package com.payroll.platform.user.userapp.port.in;

import com.payroll.platform.user.userdomain.dto.UserResponse;

public interface FindUserByEmailUseCase {
  UserResponse findUserByEmail(String email);
}
