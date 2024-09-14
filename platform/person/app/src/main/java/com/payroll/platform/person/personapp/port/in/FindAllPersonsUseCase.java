package com.payroll.platform.person.personapp.port.in;

import com.payroll.platform.person.persondomain.dto.PersonResponse;
import java.util.List;

public interface FindAllPersonsUseCase {
  List<PersonResponse> findAllPersons();
}
