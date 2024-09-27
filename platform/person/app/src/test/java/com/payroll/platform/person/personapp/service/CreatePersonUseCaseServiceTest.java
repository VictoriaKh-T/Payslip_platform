package com.payroll.platform.person.personapp.service;

import static org.mockito.Mockito.when;

import com.payroll.platform.person.personapp.port.out.persistence.PersonPersistencePort;
import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreatePersonUseCaseServiceTest {
  @Mock private PersonPersistencePort personPersistencePort;

  @InjectMocks private CreatePersonUseCaseService createPersonUseCaseService;

  @Test
  public void testCreatePersonOK() {
    CreatePersonRequest request =
        new CreatePersonRequest(
            1L, "john.doe@example.com", "John", "Michael", "Doe", LocalDate.of(1990, 1, 1));
    CreatePersonResponse expectedResponse =
        new CreatePersonResponse(
            1L, "john.doe@example.com", "John", "Michael", "Doe", LocalDate.of(1990, 1, 1));

    when(personPersistencePort.createPerson(request)).thenReturn(expectedResponse);
    CreatePersonResponse actualResponse = createPersonUseCaseService.createPerson(request);
    Assertions.assertEquals(expectedResponse, actualResponse);
  }
}
