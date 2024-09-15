package com.payroll.platform.person.personapp.service;

import com.payroll.platform.hexagonal.annotations.UseCase;
import com.payroll.platform.person.personapp.port.in.FindPersonByIdUseCase;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.persondomain.dto.PersonResponse;

@UseCase
public class FindPersonByIdService implements FindPersonByIdUseCase {

    private final PersonRepository personRepository;

    public FindPersonByIdService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonResponse findPersonById(Long id) {
        return personRepository.findPersonById(id);
    }
}
