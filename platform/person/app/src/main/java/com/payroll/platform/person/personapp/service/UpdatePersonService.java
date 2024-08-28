package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.UpdatePersonUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.userdomain.dto.UpdatePersonRequest;
import com.payroll.platform.person.userdomain.dto.UpdatePersonResponse;

@UseCase
public class UpdatePersonService implements UpdatePersonUseCase {
  private final PersonRepository personRepository;

  public UpdatePersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public UpdatePersonResponse updatePersonById(Long id, UpdatePersonRequest request) {
    return personRepository.updatePerson(id, request);
  }
}
