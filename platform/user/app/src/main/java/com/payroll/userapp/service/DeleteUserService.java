package com.payroll.userapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.userapp.port.in.DeleteUserUseCase;
import com.payroll.userapp.port.out.persistence.UserRepository;

@UseCase
public class DeleteUserService implements DeleteUserUseCase {
    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}
