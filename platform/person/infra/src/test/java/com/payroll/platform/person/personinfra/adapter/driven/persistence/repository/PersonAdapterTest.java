package com.payroll.platform.person.personinfra.adapter.driven.persistence.repository;

import com.payroll.platform.person.persondomain.dto.CreatePersonRequest;
import com.payroll.platform.person.persondomain.dto.CreatePersonResponse;
import com.payroll.platform.person.personinfra.adapter.driven.persistence.entity.PersonEntity;
import com.payroll.platform.person.personinfra.mapper.PersonEntity2Dto;
import com.payroll.platform.person.personinfra.mapper.PersonEntityToCreateDtoMapper;
import com.payroll.platform.person.personinfra.mapper.PersonEntityToUpdateDtoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonAdapterTest {

    @Mock
    private PersonPostgresRepository repository;
    @InjectMocks
    private PersonAdapter adapter;

    @Test
    void createPersonSuccess() {
        CreatePersonRequest request = new CreatePersonRequest(
                1L,
                "john.doe@example.com",
                "John",
                "Michael",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );
        CreatePersonResponse response = new CreatePersonResponse(
                1L,
                "john.doe@example.com",
                "John",
                "Michael",
                "Doe",
                LocalDate.of(1990, 1, 1)
        );

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
    public void updatePerson() {
    }

    @Test
    public void deletePersonById() {
    }

    @Test
    public void findPersonByBirth() {
    }

    @Test
    public void findPersonByEmail() {
    }

    @Test
    public void findAllPersons() {
    }
}