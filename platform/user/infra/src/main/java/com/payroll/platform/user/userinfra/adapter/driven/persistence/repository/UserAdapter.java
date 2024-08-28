package com.payroll.platform.user.userinfra.adapter.driven.persistence.repository;

import com.payroll.platform.hexagonal.annotations.Adapter;
import com.payroll.platform.user.userapp.port.out.persistence.UserRepository;
import com.payroll.platform.user.userdomain.dto.CreateUserRequest;
import com.payroll.platform.user.userdomain.dto.CreateUserResponse;
import com.payroll.platform.user.userdomain.dto.UpdateUserRequest;
import com.payroll.platform.user.userdomain.dto.UpdateUserResponse;
import com.payroll.platform.user.userdomain.dto.UserResponse;
import com.payroll.platform.user.userinfra.adapter.driven.persistence.entity.Role;
import com.payroll.platform.user.userinfra.adapter.driven.persistence.entity.UserEntity;
import com.payroll.platform.user.userinfra.exeption.UserNotFoundException;
import com.payroll.platform.user.userinfra.mapper.UserEntity2Dto;
import com.payroll.platform.user.userinfra.mapper.UserEntityToCreateDtoMapper;
import com.payroll.platform.user.userinfra.mapper.UserEntityToUpdateDtoMapper;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Adapter
public class UserAdapter implements UserRepository {
  private final UserPostgresRepository repository;
  private final UserEntityToCreateDtoMapper createMapper = UserEntityToCreateDtoMapper.INSTANCE;
  private final UserEntityToUpdateDtoMapper updateMapper = UserEntityToUpdateDtoMapper.INSTANCE;
  private final UserEntity2Dto mapper = UserEntity2Dto.INSTANCE;

  public UserAdapter(UserPostgresRepository repository) {
    this.repository = repository;
  }

  @Override
  public CreateUserResponse createUser(CreateUserRequest request) {
    return createMapper.mapToCreateResponse(repository.save(createMapper.mapToEntity(request)));
  }

  @Override
  public UpdateUserResponse updateUser(Long userId, UpdateUserRequest request) {
    UserEntity user =
        repository
            .findById(userId)
            .orElseThrow(() -> new UserNotFoundException("can`t find user by id " + userId));
    user.setDate(request.birthDate());
    user.setEmail(request.email());
    user.setSurname(request.surname());
    user.setFirstName(request.firstName());
    user.setSecondName(request.secondName());
    user.setRoles(Set.of(Role.valueOf(request.role())));
    return updateMapper.mapToUserUpdateResponse(user);
  }

  @Override
  public void deleteUserById(Long userId) {
    UserEntity user =
        repository
            .findById(userId)
            .orElseThrow(() -> new UserNotFoundException("can`t find user by id " + userId));
    user.setDelete(true);
  }

  @Override
  public UserResponse findUserByBirth(Date date) {
    UserEntity user =
        repository
            .findUserEntityByDate(date)
            .orElseThrow(() -> new UserNotFoundException("user not found"));
    return mapper.mapToUserResponse(user);
  }

  @Override
  public UserResponse findUserByEmail(String email) {
    UserEntity user =
        repository
            .findUserEntityByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("user not found"));
    return mapper.mapToUserResponse(user);
  }

  @Override
  public List<UserResponse> findAllUsers() {
    return repository.findAll().stream().map(mapper::mapToUserResponse).toList();
  }
}
