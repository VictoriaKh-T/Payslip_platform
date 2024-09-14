package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.FindAllPersonsUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.persondomain.dto.PersonResponse;
import java.util.List;

@UseCase
public class FindAllPersonsService implements FindAllPersonsUseCase {
  private final PersonRepository personRepository;

  public FindAllPersonsService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public List<PersonResponse> findAllPersons() {
    return personRepository.findAllPersons();
  }
}
