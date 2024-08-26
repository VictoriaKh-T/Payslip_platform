package com.payroll.userinfra.adapter.driving.controller;

import com.payroll.userapp.port.in.CreateUserUseCase;
import com.payroll.userapp.port.in.DeleteUserUseCase;
import com.payroll.userapp.port.in.FindAllUsersUseCase;
import com.payroll.userapp.port.in.FindUserByBirthUseCase;
import com.payroll.userapp.port.in.FindUserByEmailUseCase;
import com.payroll.userapp.port.in.UpdateUserUseCase;
import com.payroll.userdomain.dto.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Tag(name = "Get organizations", description = "This endpoint get all organizations")
    public List<UserResponse> findAllOrganizations() {
        return findAllUsersUseCase.findAllUsers();
    }


}
