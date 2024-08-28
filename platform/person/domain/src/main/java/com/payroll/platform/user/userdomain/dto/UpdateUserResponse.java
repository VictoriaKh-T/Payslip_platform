package com.payroll.platform.user.userdomain.dto;

import java.util.Date;
import java.util.Set;

public record UpdateUserResponse(
    Long id,
    String email,
    String firstName,
    String secondName,
    String surname,
    Date birthDate,
    Set<String> role) {}
