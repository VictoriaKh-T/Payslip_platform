package com.payroll.platform.person.personapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.persondomain.dto.PersonResponse;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindAllPersonsServiceTest {

  @Mock private PersonRepository personRepository;

  @InjectMocks FindAllPersonsService findAllPersonsService;

  @Test
  public void SuccessFindAllPersonsService() {

    List<PersonResponse> personList =
        List.of(
            new PersonResponse(
                1L, "john.doe@example.com", "John", "Michael", "Doe", LocalDate.of(1990, 1, 1)),
            new PersonResponse(
                2L, "jane.smith@example.com", "Jane", "Emily", "Smith", LocalDate.of(1985, 5, 20)),
            new PersonResponse(
                3L,
                "alex.jones@example.com",
                "Alex",
                "James",
                "Jones",
                LocalDate.of(1992, 12, 15)));

    when(personRepository.findAllPersons()).thenReturn(personList);

    List<PersonResponse> result = findAllPersonsService.findAllPersons();
    assertEquals(3, result.size());
  }
}
