package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.userdomain.dto.PersonResponse;
import java.util.Date;

public interface FindPersonByBirthUseCase {
  PersonResponse findPersonByBirth(Date date);
}
