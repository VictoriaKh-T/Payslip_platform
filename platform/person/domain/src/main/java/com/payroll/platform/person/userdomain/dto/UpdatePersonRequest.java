package com.payroll.platform.person.userdomain.dto;

import java.util.Date;

public record UpdatePersonRequest(
    String email, String firstName, String secondName, String surname, Date birthDate) {}
