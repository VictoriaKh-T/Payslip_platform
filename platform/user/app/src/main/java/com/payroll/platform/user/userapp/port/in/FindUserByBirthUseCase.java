package com.payroll.platform.user.userapp.port.in;

import com.payroll.platform.user.userdomain.dto.UserResponse;
import java.util.Date;

public interface FindUserByBirthUseCase {
    UserResponse findUserByBirth(Date date);
}
