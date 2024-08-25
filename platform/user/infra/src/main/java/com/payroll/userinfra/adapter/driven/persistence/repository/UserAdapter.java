package com.payroll.userinfra.adapter.driven.persistence.repository;

import com.payroll.platform.hexagonal.annotations.Adapter;
import com.payroll.userapp.port.out.persistence.UserRepository;
import com.payroll.userdomain.dto.CreateUserRequest;
import com.payroll.userdomain.dto.CreateUserResponse;
import com.payroll.userdomain.dto.UpdateUserRequest;
import com.payroll.userdomain.dto.UpdateUserResponse;
import com.payroll.userdomain.dto.UserResponse;
import java.time.LocalDate;

@Adapter
public class UserAdapter implements UserRepository {
    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        return null;
    }

    @Override
    public UpdateUserResponse updateUser(Long id, UpdateUserRequest request) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public UserResponse findUserByBirth(LocalDate date) {
        return null;
    }

    @Override
    public UserResponse findUserByEmail(String email) {
        return null;
    }
}
