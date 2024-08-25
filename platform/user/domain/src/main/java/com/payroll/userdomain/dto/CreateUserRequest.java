package com.payroll.userdomain.dto;

import java.time.LocalDate;

public record CreateUserRequest(
        Long id, String email, String first_name, String second_name, String surname, LocalDate birth_date) {
}
