package com.payroll.platform.user.userapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.user.userapp.port.in.FindUserByEmailUseCase;
import com.payroll.platform.user.userapp.port.out.persistence.UserRepository;
import com.payroll.platform.user.userdomain.dto.UserResponse;

@UseCase
public class FindUserByEmailService implements FindUserByEmailUseCase {
    private final UserRepository userRepository;

    public FindUserByEmailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
