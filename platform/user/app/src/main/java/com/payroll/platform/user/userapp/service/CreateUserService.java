package com.payroll.platform.user.userapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.user.userapp.port.in.CreateUserUseCase;
import com.payroll.platform.user.userapp.port.out.persistence.UserRepository;
import com.payroll.platform.user.userdomain.dto.CreateUserRequest;
import com.payroll.platform.user.userdomain.dto.CreateUserResponse;

@UseCase
public class CreateUserService implements CreateUserUseCase {

  private final UserRepository userRepository;

  public CreateUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public CreateUserResponse createUser(CreateUserRequest request) {
    return userRepository.createUser(request);
  }
}
