package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.CreatePersonUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;

@UseCase
public class CreatePersonService implements CreatePersonUseCase {

  private final PersonRepository personRepository;

  public CreatePersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public CreatePersonResponse createPerson(CreatePersonRequest request) {
    return personRepository.createPerson(request);
  }
}
