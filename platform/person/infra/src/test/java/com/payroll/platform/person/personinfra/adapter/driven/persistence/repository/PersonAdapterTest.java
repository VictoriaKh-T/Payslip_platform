package com.payroll.platform.person.personinfra.adapter.driven.persistence.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;
import com.payroll.platform.person.persondomain.dto.PersonResponse;
import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import com.payroll.platform.person.personinfra.exeption.PersonNotFoundException;
import com.payroll.platform.person.personinfra.mapper.PersonEntity2Dto;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonAdapterTest {

  @Mock private PersonPostgresRepository repository;
  @Mock private PersonEntity2Dto personEntity2Dto;
  @InjectMocks private PersonAdapter adapter;

  @Test
  void createPersonSuccess() {
    CreatePersonRequest request =
        new CreatePersonRequest(
            1L, "john.doe@example.com", "John", "Michael", "Doe", LocalDate.of(1990, 1, 1));
    CreatePersonResponse response =
        new CreatePersonResponse(
            1L, "john.doe@example.com", "John", "Michael", "Doe", LocalDate.of(1990, 1, 1));

    PersonEntity person = new PersonEntity();
    person.setEmail(request.email());
    person.setSurname(request.surname());
    person.setBirthDate(request.birthDate());
    person.setSecondName(request.secondName());
    person.setFirstName(request.firstName());
    person.setId(request.id());

    when(repository.save(person)).thenReturn(person);

    CreatePersonResponse actualResponse = adapter.createPerson(request);

    assertEquals(response.id(), actualResponse.id());
    assertEquals(response.firstName(), actualResponse.firstName());
    assertEquals(response.birthDate(), actualResponse.birthDate());
    assertEquals(response.email(), actualResponse.email());
  }

  @Test
  public void findPersonByIdOk() {
    Long personId = 1L;

    PersonEntity person = new PersonEntity();
    person.setId(1L);
    person.setEmail("john.doe@example.com");
    person.setFirstName("Anna");
    person.setSecondName("Grygorievna");
    person.setSurname("Sych");
    person.setBirthDate(LocalDate.of(1991, 1, 1));

    PersonResponse response =
        new PersonResponse(
            1L, "john.doe@example.com", "Anna", "Grygorievna", "Sych", LocalDate.of(1991, 1, 1));

    when(repository.findById(personId)).thenReturn(Optional.of(person));
    lenient().when(personEntity2Dto.mapToPersonResponse(person)).thenReturn(response);

    PersonResponse actualResponse = adapter.findPersonById(personId);

    assertEquals(response.id(), actualResponse.id());
    assertEquals(response.firstName(), actualResponse.firstName());
    assertEquals(response.birthDate(), actualResponse.birthDate());
    assertEquals(response.email(), actualResponse.email());
  }

  @Test
  void findPersonByIdThrowsPersonNotFoundException() {
    Long nonExistingUserId = 1L;

    when(repository.findById(nonExistingUserId)).thenReturn(Optional.empty());

    PersonNotFoundException exception =
        assertThrows(
            PersonNotFoundException.class,
            () -> adapter.findPersonById(nonExistingUserId),
            "Expected findPersonById() to throw PersonNotFoundException");

    assertEquals("can`t find person by id 1", exception.getMessage());
    verify(repository, times(1)).findById(nonExistingUserId);
  }

  @Test
  public void findPersonByBirthOk() {
    LocalDate birthDate = LocalDate.of(1991, 1, 1);

    PersonEntity person = new PersonEntity();
    person.setId(1L);
    person.setEmail("john.doe@example.com");
    person.setFirstName("Anna");
    person.setSecondName("Grygorievna");
    person.setSurname("Sych");
    person.setBirthDate(LocalDate.of(1991, 1, 1));

    PersonResponse response =
        new PersonResponse(
            1L, "john.doe@example.com", "Anna", "Grygorievna", "Sych", LocalDate.of(1991, 1, 1));

    when(repository.findPersonEntityByBirthDate(birthDate)).thenReturn(Optional.of(person));
    lenient().when(personEntity2Dto.mapToPersonResponse(person)).thenReturn(response);

    PersonResponse actualResponse = adapter.findPersonByBirth(birthDate);
    assertEquals(response.email(), actualResponse.email());
  }

  @Test
  public void findPersonByEmailOk() {
    String email = "john.doe@example.com";

    PersonEntity person = new PersonEntity();
    person.setId(1L);
    person.setEmail("john.doe@example.com");
    person.setFirstName("Anna");
    person.setSecondName("Grygorievna");
    person.setSurname("Sych");
    person.setBirthDate(LocalDate.of(1991, 1, 1));

    PersonResponse response =
        new PersonResponse(
            1L, "john.doe@example.com", "Anna", "Grygorievna", "Sych", LocalDate.of(1991, 1, 1));

    when(repository.findPersonEntityByEmail(email)).thenReturn(Optional.of(person));
    lenient().when(personEntity2Dto.mapToPersonResponse(person)).thenReturn(response);

    PersonResponse actualResponse = adapter.findPersonByEmail(email);
    assertEquals(response.email(), actualResponse.email());
  }

  @Test
  void findPersonByEmailThrowsPersonNotFoundException() {
    String nonExistingEmail = "nonexistent@example.com";

    when(repository.findPersonEntityByEmail(nonExistingEmail)).thenReturn(Optional.empty());

    PersonNotFoundException exception =
        assertThrows(
            PersonNotFoundException.class,
            () -> adapter.findPersonByEmail(nonExistingEmail),
            "Expected findPersonByEmail() to throw PersonNotFoundException");

    assertEquals("person not found", exception.getMessage());
    verify(repository, times(1)).findPersonEntityByEmail(nonExistingEmail);
  }
}
