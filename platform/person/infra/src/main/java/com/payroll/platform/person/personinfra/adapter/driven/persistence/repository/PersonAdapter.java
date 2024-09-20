package com.payroll.platform.person.personinfra.adapter.driven.persistence.repository;

import com.payroll.platform.hexagonal.annotations.Adapter;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;
import com.payroll.platform.person.persondomain.dto.PersonResponse;
import com.payroll.platform.person.persondomain.dto.UpdatePersonRequest;
import com.payroll.platform.person.persondomain.dto.UpdatePersonResponse;
import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import com.payroll.platform.person.personinfra.exeption.PersonNotFoundException;
import com.payroll.platform.person.personinfra.mapper.PersonEntity2Dto;
import com.payroll.platform.person.personinfra.mapper.PersonEntityToCreateDtoMapper;
import com.payroll.platform.person.personinfra.mapper.PersonEntityToUpdateDtoMapper;
import java.time.LocalDate;
import java.util.List;

@Adapter
public class PersonAdapter implements PersonRepository {
  private final PersonPostgresRepository repository;
  private final PersonEntityToCreateDtoMapper createMapper = PersonEntityToCreateDtoMapper.INSTANCE;
  private final PersonEntityToUpdateDtoMapper updateMapper = PersonEntityToUpdateDtoMapper.INSTANCE;
  private final PersonEntity2Dto mapper = PersonEntity2Dto.INSTANCE;

  public PersonAdapter(PersonPostgresRepository repository) {
    this.repository = repository;
  }

  @Override
  public CreatePersonResponse createPerson(CreatePersonRequest request) {
    return createMapper.mapToCreateResponse(repository.save(createMapper.mapToEntity(request)));
  }

  @Override
  public UpdatePersonResponse updatePerson(Long personId, UpdatePersonRequest request) {
    PersonEntity person =
        repository
            .findById(personId)
            .orElseThrow(() -> new PersonNotFoundException("can`t find person by id " + personId));
    person.setBirthDate(request.birthDate());
    person.setEmail(request.email());
    person.setSurname(request.surname());
    person.setFirstName(request.firstName());
    person.setSecondName(request.secondName());
    return updateMapper.mapToPersonUpdateResponse(repository.save(person));
  }

  @Override
  public void deletePersonById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public PersonResponse findPersonByBirth(LocalDate birthDate) {
    PersonEntity person =
        repository
            .findPersonEntityByBirthDate(birthDate)
            .orElseThrow(() -> new PersonNotFoundException("person not found"));
    return mapper.mapToPersonResponse(person);
  }

  @Override
  public PersonResponse findPersonById(Long userId) {
    PersonEntity person =
        repository
            .findById(userId)
            .orElseThrow(() -> new PersonNotFoundException("can`t find person by id " + userId));
    return mapper.mapToPersonResponse(person);
  }

  @Override
  public PersonResponse findPersonByEmail(String email) {
    PersonEntity person =
        repository
            .findPersonEntityByEmail(email)
            .orElseThrow(() -> new PersonNotFoundException("person not found"));
    return mapper.mapToPersonResponse(person);
  }

  @Override
  public List<PersonResponse> findAllPersons() {
    return repository.findAll().stream().map(mapper::mapToPersonResponse).toList();
  }
}
