package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.FindPersonByIdUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonPersistencePort;
import com.payroll.platform.person.persondomain.dto.PersonResponse;

@UseCase
public class FindPersonByIdUseCaseService implements FindPersonByIdUseCase {

  private final PersonPersistencePort personPersistencePort;

  public FindPersonByIdUseCaseService(PersonPersistencePort personPersistencePort) {
    this.personPersistencePort = personPersistencePort;
  }

  @Override
  public PersonResponse findPersonById(Long id) {
    return personPersistencePort.findPersonById(id);
  }
}
