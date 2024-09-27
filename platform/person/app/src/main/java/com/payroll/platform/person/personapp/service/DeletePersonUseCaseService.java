package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.DeletePersonUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonPersistencePort;

@UseCase
public class DeletePersonUseCaseService implements DeletePersonUseCase {
  private final PersonPersistencePort personPersistencePort;

  public DeletePersonUseCaseService(PersonPersistencePort personPersistencePort) {
    this.personPersistencePort = personPersistencePort;
  }

  @Override
  public void deletePersonById(Long id) {
    personPersistencePort.deletePersonById(id);
  }
}
