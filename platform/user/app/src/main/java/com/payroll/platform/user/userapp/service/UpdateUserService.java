package com.payroll.platform.user.userapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.user.userapp.port.in.UpdateUserUseCase;
import com.payroll.platform.user.userapp.port.out.persistence.UserRepository;
import com.payroll.platform.user.userdomain.dto.UpdateUserRequest;
import com.payroll.platform.user.userdomain.dto.UpdateUserResponse;

@UseCase
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
