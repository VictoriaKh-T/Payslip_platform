package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.UpdatePersonUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonPersistencePort;
import com.payroll.platform.person.persondomain.dto.UpdatePersonRequest;
import com.payroll.platform.person.persondomain.dto.UpdatePersonResponse;

@UseCase
public class UpdatePersonUseCaseService implements UpdatePersonUseCase {
  private final PersonPersistencePort personPersistencePort;

  public UpdatePersonUseCaseService(PersonPersistencePort personPersistencePort) {
    this.personPersistencePort = personPersistencePort;
  }

  @Override
  public UpdatePersonResponse updatePersonById(Long id, UpdatePersonRequest request) {
    return personPersistencePort.updatePerson(id, request);
  }
}
