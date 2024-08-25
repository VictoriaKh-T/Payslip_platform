package com.payroll.userapp.service;

import com.payroll.userapp.port.in.UpdateUserUseCase;
import com.payroll.userapp.port.out.persistence.UserRepository;
import com.payroll.userdomain.dto.UpdateUserRequest;
import com.payroll.userdomain.dto.UpdateUserResponse;

public class UpdateUserService implements UpdateUserUseCase {
    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UpdateUserResponse updateUserById(Long id, UpdateUserRequest request) {
        return userRepository.updateUser(id, request);
    }
}
