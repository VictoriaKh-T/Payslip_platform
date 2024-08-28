package com.payroll.platform.user.userdomain.dto;

import java.util.Date;

public record UpdateUserResponse(
        Long id, String email, String firstName, String secondName, String surname, Date birthDate) {
}
