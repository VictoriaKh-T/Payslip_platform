package com.payroll.platform.person.persondomain.dto;

import java.time.LocalDate;

public record CreatePersonRequest(
    Long id,
    String email,
    String firstName,
    String secondName,
    String surname,
    LocalDate birthDate) {}
