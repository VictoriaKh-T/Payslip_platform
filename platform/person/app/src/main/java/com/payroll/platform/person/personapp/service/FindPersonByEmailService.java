package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.FindPersonByEmailUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.userdomain.dto.PersonResponse;

@UseCase
public class FindPersonByEmailService implements FindPersonByEmailUseCase {
  private final PersonRepository personRepository;

  public FindPersonByEmailService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public PersonResponse findPersonByEmail(String email) {
    return personRepository.findPersonByEmail(email);
  }
}
