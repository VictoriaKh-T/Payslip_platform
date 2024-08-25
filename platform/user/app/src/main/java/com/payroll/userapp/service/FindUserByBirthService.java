package com.payroll.userapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.userapp.port.in.FindUserByBirthUseCase;
import com.payroll.userapp.port.out.persistence.UserRepository;
import com.payroll.userdomain.dto.UserResponse;

import java.time.LocalDate;

@UseCase
public class FindUserByBirthService implements FindUserByBirthUseCase {

    private final UserRepository userRepository;

    public FindUserByBirthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse findUserByBirth(LocalDate date) {
        return userRepository.findUserByBirth(date);
    }
}
