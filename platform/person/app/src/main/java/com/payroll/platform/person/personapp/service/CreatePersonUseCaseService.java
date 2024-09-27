package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.CreatePersonUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonPersistencePort;
import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;

@UseCase
public class CreatePersonUseCaseService implements CreatePersonUseCase {

  private final PersonPersistencePort personPersistencePort;

  public CreatePersonUseCaseService(PersonPersistencePort personPersistencePort) {
    this.personPersistencePort = personPersistencePort;
  }

  @Override
  public CreatePersonResponse createPerson(CreatePersonRequest request) {
    return personPersistencePort.createPerson(request);
  }
}
