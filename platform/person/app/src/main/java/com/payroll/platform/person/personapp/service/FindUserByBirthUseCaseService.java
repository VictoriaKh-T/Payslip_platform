package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.FindPersonByBirthUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonPersistencePort;
import com.payroll.platform.person.persondomain.dto.PersonResponse;
import java.time.LocalDate;

@UseCase
public class FindUserByBirthUseCaseService implements FindPersonByBirthUseCase {

  private final PersonPersistencePort personPersistencePort;

  public FindUserByBirthUseCaseService(PersonPersistencePort personPersistencePort) {
    this.personPersistencePort = personPersistencePort;
  }

  @Override
  public PersonResponse findPersonByBirth(LocalDate birthDate) {
    return personPersistencePort.findPersonByBirth(birthDate);
  }
}
