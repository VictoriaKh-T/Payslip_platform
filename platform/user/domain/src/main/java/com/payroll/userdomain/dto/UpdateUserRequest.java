package com.payroll.userdomain.dto;

import java.util.Date;

public record UpdateUserRequest(
        String email, String firstName, String secondName, String surname, Date birthDate) {
}
