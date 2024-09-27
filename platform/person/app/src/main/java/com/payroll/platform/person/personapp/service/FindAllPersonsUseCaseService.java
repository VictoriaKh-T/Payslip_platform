package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.FindAllPersonsUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonPersistencePort;
import com.payroll.platform.person.persondomain.dto.PersonResponse;
import java.util.List;

@UseCase
public class FindAllPersonsUseCaseService implements FindAllPersonsUseCase {
  private final PersonPersistencePort personPersistencePort;

  public FindAllPersonsUseCaseService(PersonPersistencePort personPersistencePort) {
    this.personPersistencePort = personPersistencePort;
  }

  @Override
  public List<PersonResponse> findAllPersons() {
    return personPersistencePort.findAllPersons();
  }
}
