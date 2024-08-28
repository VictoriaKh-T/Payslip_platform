package com.payroll.platform.user.userapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.user.userapp.port.in.FindUserByBirthUseCase;
import com.payroll.platform.user.userapp.port.out.persistence.UserRepository;
import com.payroll.platform.user.userdomain.dto.UserResponse;
import java.util.Date;

@UseCase
public class FindUserByBirthService implements FindUserByBirthUseCase {

    private final UserRepository userRepository;

    public FindUserByBirthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse findUserByBirth(Date date) {
        return userRepository.findUserByBirth(date);
    }
}
