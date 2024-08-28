package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.userdomain.dto.CreatePersonRequest;
import com.payroll.platform.person.userdomain.dto.CreatePersonResponse;

public interface CreatePersonUseCase {
  CreatePersonResponse createPerson(CreatePersonRequest request);
}
