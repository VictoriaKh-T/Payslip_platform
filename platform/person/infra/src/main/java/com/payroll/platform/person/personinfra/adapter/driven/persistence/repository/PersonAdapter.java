package com.payroll.platform.person.personinfra.adapter.driven.persistence.repository;

import com.payroll.platform.hexagonal.annotations.Adapter;
import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import com.payroll.platform.person.personinfra.exeption.PersonNotFoundException;
import com.payroll.platform.person.personinfra.mapper.PersonEntity2Dto;
import com.payroll.platform.person.personinfra.mapper.PersonEntityToCreateDtoMapper;
import com.payroll.platform.person.personinfra.mapper.PersonEntityToUpdateDtoMapper;
import com.payroll.platform.person.userdomain.dto.CreatePersonRequest;
import com.payroll.platform.person.userdomain.dto.CreatePersonResponse;
import com.payroll.platform.person.userdomain.dto.PersonResponse;
import com.payroll.platform.person.userdomain.dto.UpdatePersonRequest;
import com.payroll.platform.person.userdomain.dto.UpdatePersonResponse;
import java.util.Date;
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
  public UpdatePersonResponse updatePerson(Long userId, UpdatePersonRequest request) {
    PersonEntity user =
        repository
            .findById(userId)
            .orElseThrow(() -> new PersonNotFoundException("can`t find user by id " + userId));
    user.setDate(request.birthDate());
    user.setEmail(request.email());
    user.setSurname(request.surname());
    user.setFirstName(request.firstName());
    user.setSecondName(request.secondName());
    return updateMapper.mapToPersonUpdateResponse(user);
  }

  @Override
  public void deletePersonById(Long userId) {
    PersonEntity user =
        repository
            .findById(userId)
            .orElseThrow(() -> new PersonNotFoundException("can`t find user by id " + userId));
    user.setDelete(true);
    repository.save(user);
  }

  @Override
  public PersonResponse findPersonByBirth(Date date) {
    PersonEntity user =
        repository
            .findUserEntityByDate(date)
            .orElseThrow(() -> new PersonNotFoundException("user not found"));
    return mapper.mapToUserResponse(user);
  }

  @Override
  public PersonResponse findPersonByEmail(String email) {
    PersonEntity user =
        repository
            .findUserEntityByEmail(email)
            .orElseThrow(() -> new PersonNotFoundException("user not found"));
    return mapper.mapToUserResponse(user);
  }

  @Override
  public List<PersonResponse> findAllPersons() {
    return repository.findAll().stream().map(mapper::mapToUserResponse).toList();
  }
}
