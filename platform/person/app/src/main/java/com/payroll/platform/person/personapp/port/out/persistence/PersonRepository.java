package com.payroll.platform.person.personapp.port.out.persistence;

import com.payroll.platform.person.userdomain.dto.CreatePersonRequest;
import com.payroll.platform.person.userdomain.dto.CreatePersonResponse;
import com.payroll.platform.person.userdomain.dto.PersonResponse;
import com.payroll.platform.person.userdomain.dto.UpdatePersonRequest;
import com.payroll.platform.person.userdomain.dto.UpdatePersonResponse;
import java.time.LocalDate;
import java.util.List;

public interface PersonRepository {
  CreatePersonResponse createPerson(CreatePersonRequest request);

  UpdatePersonResponse updatePerson(Long id, UpdatePersonRequest request);

  void deletePersonById(Long id);

  PersonResponse findPersonByBirth(LocalDate date);

  PersonResponse findPersonByEmail(String email);

  List<PersonResponse> findAllPersons();
}
