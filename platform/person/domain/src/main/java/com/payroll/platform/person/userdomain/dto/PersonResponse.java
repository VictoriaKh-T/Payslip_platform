package com.payroll.platform.person.userdomain.dto;

import java.util.Date;

public record PersonResponse(
    Long id, String email, String firstName, String secondName, String surname, Date birthDate) {}
