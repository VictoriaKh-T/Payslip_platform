package com.payroll.userinfra.adapter.driven.persistence.repository;

import com.payroll.platform.hexagonal.annotations.Adapter;
import com.payroll.userapp.port.out.persistence.UserRepository;
import com.payroll.userdomain.dto.CreateUserRequest;
import com.payroll.userdomain.dto.CreateUserResponse;
import com.payroll.userdomain.dto.UpdateUserRequest;
import com.payroll.userdomain.dto.UpdateUserResponse;
import com.payroll.userdomain.dto.UserResponse;
import com.payroll.userinfra.adapter.driven.persistence.entity.UserEntity;
import com.payroll.userinfra.exeption.UserNotFoundException;
import com.payroll.userinfra.mapper.UserEntity2Dto;
import com.payroll.userinfra.mapper.UserEntityToCreateDtoMapper;
import com.payroll.userinfra.mapper.UserEntityToUpdateDtoMapper;
import java.util.Date;
import java.util.List;

@Adapter
public class UserAdapter implements UserRepository {
    private final UserPostgresRepository repository;
    private final UserEntityToCreateDtoMapper createMapper =
            UserEntityToCreateDtoMapper.INSTANCE;

    private final UserEntityToUpdateDtoMapper updateMapper =
            UserEntityToUpdateDtoMapper.INSTANCE;
    private final UserEntity2Dto mapper =
            UserEntity2Dto.INSTANCE;


    public UserAdapter(UserPostgresRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        return createMapper.mapToCreateResponse(repository.save(createMapper.mapToEntity(request)));
    }

    @Override
    public UpdateUserResponse updateUser(Long userId, UpdateUserRequest request) {
        UserEntity user = repository.findById(userId).orElseThrow(
                () ->
                        new UserNotFoundException(
                                "can`t find user by id " + userId));
        user.setDate(request.birthDate());
        user.setEmail(request.email());
        user.setSurname(request.surname());
        user.setFirstName(request.firstName());
        user.setSecondName(request.secondName());
        return updateMapper.mapToUserUpdateResponse(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        UserEntity user = repository.findById(userId).orElseThrow(
                () ->
                        new UserNotFoundException(
                                "can`t find user by id " + userId));
        repository.delete(user);
    }

    @Override
    public UserResponse findUserByBirth(Date date) {
        UserEntity user = repository.findUserEntityByDate(date).orElseThrow(
                () ->
                        new UserNotFoundException(
                                "user not found"));
        return mapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse findUserByEmail(String email) {
        UserEntity user = repository.findUserEntityByEmail(email).orElseThrow(
                () ->
                        new UserNotFoundException(
                                "user not found"));
        return mapper.mapToUserResponse(user);
    }

    @Override
    public List<UserResponse> findAllUsers() {
        return  repository.findAll().stream()
                .map(mapper::mapToUserResponse)
                .toList();
    }
}
