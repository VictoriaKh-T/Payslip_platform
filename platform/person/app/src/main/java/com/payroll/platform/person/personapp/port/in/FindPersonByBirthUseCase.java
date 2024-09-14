package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.userdomain.dto.PersonResponse;
import java.time.LocalDate;

public interface FindPersonByBirthUseCase {
  PersonResponse findPersonByBirth(LocalDate date);
}
