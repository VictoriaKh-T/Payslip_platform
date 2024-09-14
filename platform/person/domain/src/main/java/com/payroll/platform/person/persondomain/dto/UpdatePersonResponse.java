package com.payroll.platform.person.persondomain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record UpdatePersonResponse(
    Long id, String email, String firstName, String secondName, String surname, LocalDate birthDate) {}
