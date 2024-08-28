package com.payroll.platform.user.userapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.user.userapp.port.in.DeleteUserUseCase;
import com.payroll.platform.user.userapp.port.out.persistence.UserRepository;

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
