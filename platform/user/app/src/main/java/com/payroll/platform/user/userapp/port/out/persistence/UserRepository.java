package com.payroll.platform.user.userapp.port.out.persistence;

import com.payroll.platform.user.userdomain.dto.CreateUserRequest;
import com.payroll.platform.user.userdomain.dto.CreateUserResponse;
import com.payroll.platform.user.userdomain.dto.UpdateUserRequest;
import com.payroll.platform.user.userdomain.dto.UpdateUserResponse;
import com.payroll.platform.user.userdomain.dto.UserResponse;
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
