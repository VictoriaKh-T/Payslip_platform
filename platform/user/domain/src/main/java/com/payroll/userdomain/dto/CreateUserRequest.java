package com.payroll.userdomain.dto;

import java.util.Date;

public record CreateUserRequest(
        Long id, String email, String firstName, String secondName, String surname, Date birthDate) {
}
