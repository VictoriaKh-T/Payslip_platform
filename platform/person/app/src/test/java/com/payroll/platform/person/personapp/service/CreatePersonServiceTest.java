package com.payroll.platform.person.personapp.service;

import com.payroll.platform.person.personapp.port.out.persistence.PersonRepository;
import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private CreatePersonService createPersonService;

    @Test
    public void testCreatePersonOK() {
        CreatePersonRequest request = new CreatePersonRequest(
                1L,
                "john.doe@example.com",
                "John",
                "Michael",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );
        CreatePersonResponse expectedResponse = new CreatePersonResponse(
                1L,
                "john.doe@example.com",
                "John",
                "Michael",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );

        when(personRepository.createPerson(request)).thenReturn(expectedResponse);
        CreatePersonResponse actualResponse = createPersonService.createPerson(request);
        Assertions.assertEquals(expectedResponse, actualResponse);
    }

}