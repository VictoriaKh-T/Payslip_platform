package com.payroll.userapp.port.out.persistence;

import com.payroll.userdomain.dto.CreateUserRequest;
import com.payroll.userdomain.dto.CreateUserResponse;
import com.payroll.userdomain.dto.UpdateUserRequest;
import com.payroll.userdomain.dto.UpdateUserResponse;
import com.payroll.userdomain.dto.UserResponse;
import java.util.Date;
import java.util.List;

public interface UserRepository {
    CreateUserResponse createUser(CreateUserRequest request);
    UpdateUserResponse updateUser(Long id, UpdateUserRequest request);
    void deleteUserById(Long id);
    UserResponse findUserByBirth(Date date);
    UserResponse findUserByEmail(String email);
    List<UserResponse> findAllUsers();
}
