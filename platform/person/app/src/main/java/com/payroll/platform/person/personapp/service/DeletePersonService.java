package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.DeletePersonUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;

@UseCase
public class DeletePersonService implements DeletePersonUseCase {
  private final PersonRepository personRepository;

  public DeletePersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public void deletePersonById(Long id) {
    personRepository.deletePersonById(id);
  }
}
