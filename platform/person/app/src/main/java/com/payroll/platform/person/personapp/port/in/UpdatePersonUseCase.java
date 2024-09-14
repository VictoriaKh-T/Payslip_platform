package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.persondomain.dto.UpdatePersonRequest;
import com.payroll.platform.person.persondomain.dto.UpdatePersonResponse;

public interface UpdatePersonUseCase {
  UpdatePersonResponse updatePersonById(Long id, UpdatePersonRequest request);
}
