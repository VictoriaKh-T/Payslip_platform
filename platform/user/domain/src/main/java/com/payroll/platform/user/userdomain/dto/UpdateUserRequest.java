package com.payroll.platform.user.userdomain.dto;

import java.util.Date;

public record UpdateUserRequest(
    String email,
    String firstName,
    String secondName,
    String surname,
    Date birthDate,
    String role) {}
