package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.persondomain.dto.PersonResponse;

public interface FindPersonByEmailUseCase {
  PersonResponse findPersonByEmail(String email);
}
