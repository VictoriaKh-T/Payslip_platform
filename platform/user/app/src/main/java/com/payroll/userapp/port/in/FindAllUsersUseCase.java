package com.payroll.userapp.port.in;

import com.payroll.userdomain.dto.UserResponse;
import java.util.List;

public interface FindAllUsersUseCase {
    List<UserResponse> findAllUsers();
}
