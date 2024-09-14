package com.payroll.platform.person.persondomain.dto;

import java.time.LocalDate;

public record UpdatePersonRequest(
    String email, String firstName, String secondName, String surname, LocalDate birthDate) {}
