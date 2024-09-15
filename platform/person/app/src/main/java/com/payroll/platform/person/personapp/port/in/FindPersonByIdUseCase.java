package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.persondomain.dto.PersonResponse;

public interface FindPersonByIdUseCase {
  PersonResponse findPersonById(Long id);
}
