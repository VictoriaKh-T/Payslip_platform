package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;

public interface CreatePersonUseCase {
  CreatePersonResponse createPerson(CreatePersonRequest request);
}
