package com.payroll.userapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.userapp.port.in.FindAllUsersUseCase;
import com.payroll.userapp.port.out.persistence.UserRepository;
import com.payroll.userdomain.dto.UserResponse;

import java.util.List;

@UseCase
public class FindAllUsersService implements FindAllUsersUseCase {
    private final UserRepository userRepository;

    public FindAllUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
