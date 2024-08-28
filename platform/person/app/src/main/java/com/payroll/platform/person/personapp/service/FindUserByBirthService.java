package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.FindPersonByBirthUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.userdomain.dto.PersonResponse;
import java.util.Date;

@UseCase
public class FindUserByBirthService implements FindPersonByBirthUseCase {

  private final PersonRepository personRepository;

  public FindUserByBirthService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public PersonResponse findPersonByBirth(Date date) {
    return personRepository.findPersonByBirth(date);
  }
}
