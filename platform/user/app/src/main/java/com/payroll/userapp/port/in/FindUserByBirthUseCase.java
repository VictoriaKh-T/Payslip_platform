package com.payroll.userapp.port.in;

import com.payroll.userdomain.dto.UserResponse;
import java.util.Date;

public interface FindUserByBirthUseCase {
    UserResponse findUserByBirth(Date date);
}
