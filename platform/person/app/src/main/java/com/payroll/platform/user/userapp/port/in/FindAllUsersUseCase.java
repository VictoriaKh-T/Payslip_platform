package com.payroll.platform.user.userapp.port.in;

import com.payroll.platform.user.userdomain.dto.UserResponse;
import java.util.List;

public interface FindAllUsersUseCase {
  List<UserResponse> findAllUsers();
}
