package com.payroll.userapp.port.in;

import com.payroll.userdomain.dto.UserResponse;
import java.time.LocalDate;

public interface FindUserByBirthUseCase {
    UserResponse findUserByBirth(LocalDate date);
}
