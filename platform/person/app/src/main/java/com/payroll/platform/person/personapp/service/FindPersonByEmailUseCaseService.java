package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.FindPersonByEmailUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonPersistencePort;
import com.payroll.platform.person.persondomain.dto.PersonResponse;

@UseCase
public class FindPersonByEmailUseCaseService implements FindPersonByEmailUseCase {
  private final PersonPersistencePort personPersistencePort;

  public FindPersonByEmailUseCaseService(PersonPersistencePort personPersistencePort) {
    this.personPersistencePort = personPersistencePort;
  }

  @Override
  public PersonResponse findPersonByEmail(String email) {
    return personPersistencePort.findPersonByEmail(email);
  }
}
