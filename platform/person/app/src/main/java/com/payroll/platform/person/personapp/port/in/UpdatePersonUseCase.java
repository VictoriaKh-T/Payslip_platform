package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.userdomain.dto.UpdatePersonRequest;
import com.payroll.platform.person.userdomain.dto.UpdatePersonResponse;

public interface UpdatePersonUseCase {
  UpdatePersonResponse updatePersonById(Long id, UpdatePersonRequest request);
}
