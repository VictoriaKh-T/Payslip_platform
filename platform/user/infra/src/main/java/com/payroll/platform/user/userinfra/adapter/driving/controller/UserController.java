package com.payroll.platform.user.userinfra.adapter.driving.controller;

import com.payroll.platform.user.userapp.port.in.CreateUserUseCase;
import com.payroll.platform.user.userapp.port.in.DeleteUserUseCase;
import com.payroll.platform.user.userapp.port.in.FindAllUsersUseCase;
import com.payroll.platform.user.userapp.port.in.FindUserByBirthUseCase;
import com.payroll.platform.user.userapp.port.in.FindUserByEmailUseCase;
import com.payroll.platform.user.userapp.port.in.UpdateUserUseCase;
import com.payroll.platform.user.userdomain.dto.CreateUserRequest;
import com.payroll.platform.user.userdomain.dto.CreateUserResponse;
import com.payroll.platform.user.userdomain.dto.UpdateUserRequest;
import com.payroll.platform.user.userdomain.dto.UpdateUserResponse;
import com.payroll.platform.user.userdomain.dto.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@Tag(name = "User management", description = "Endpoints for managing organization")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final FindUserByBirthUseCase findUserByBirthUseCase;
    private final FindUserByEmailUseCase findUserByEmailUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;

    @GetMapping
    @Tag(name = "Get users", description = "This endpoint get all users")
    public List<UserResponse> findAllOrganizations() {
        return findAllUsersUseCase.findAllUsers();
    }

    @GetMapping("/users/findByEmail")
    @Tag(name = "Get users", description = "This endpoint get user by email")
    public UserResponse findUserByEmail(@RequestParam String email) {
        return  findUserByEmailUseCase.findUserByEmail(email);
    }

    @GetMapping("/users/findByDate")
    @Tag(name = "Get users", description = "This endpoint get user by birth date")
    public UserResponse findByDate(@RequestParam Date date) {
        return  findUserByBirthUseCase.findUserByBirth(date);
    }

    @PostMapping
    @Tag(name = "create new user", description = "This point create new user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        return  createUserUseCase.createUser(request);
    }

    @PutMapping("/{id}")
    public UpdateUserResponse updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest userRequest) {
        return updateUserUseCase.updateUserById(id, userRequest);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "delete user", description = "This point delete user")
    public void deleteUser(@PathVariable Long id) {
        deleteUserUseCase.deleteUserById(id);
    }
}
