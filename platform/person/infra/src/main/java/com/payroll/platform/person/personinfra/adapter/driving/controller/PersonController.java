package com.payroll.platform.person.personinfra.adapter.driving.controller;

import com.payroll.platform.person.personapp.port.in.CreatePersonUseCase;
import com.payroll.platform.person.personapp.port.in.DeletePersonUseCase;
import com.payroll.platform.person.personapp.port.in.FindAllPersonsUseCase;
import com.payroll.platform.person.personapp.port.in.FindPersonByBirthUseCase;
import com.payroll.platform.person.personapp.port.in.FindPersonByEmailUseCase;
import com.payroll.platform.person.personapp.port.in.UpdatePersonUseCase;
import com.payroll.platform.person.userdomain.dto.CreatePersonRequest;
import com.payroll.platform.person.userdomain.dto.CreatePersonResponse;
import com.payroll.platform.person.userdomain.dto.PersonResponse;
import com.payroll.platform.person.userdomain.dto.UpdatePersonRequest;
import com.payroll.platform.person.userdomain.dto.UpdatePersonResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User management", description = "Endpoints for managing organization")
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
  private final CreatePersonUseCase createPersonUseCase;
  private final UpdatePersonUseCase updatePersonUseCase;
  private final DeletePersonUseCase deletePersonUseCase;
  private final FindPersonByBirthUseCase findPersonByBirthUseCase;
  private final FindPersonByEmailUseCase findPersonByEmailUseCase;
  private final FindAllPersonsUseCase findAllPersonsUseCase;

  @GetMapping
  @Tag(name = "Get persons", description = "This endpoint get all persons")
  public List<PersonResponse> findAllOrganizations() {
    return findAllPersonsUseCase.findAllPersons();
  }

  @GetMapping("/findByEmail")
  @Tag(name = "Get persons", description = "This endpoint get person by email")
  public PersonResponse findPersonByEmail(@RequestParam String email) {
    return findPersonByEmailUseCase.findPersonByEmail(email);
  }

  @GetMapping("/findByDate")
  @Tag(name = "Get persons", description = "This endpoint get person by birth date")
  public PersonResponse findByDate(@RequestParam LocalDate date) {
    return findPersonByBirthUseCase.findPersonByBirth(date);
  }

  @PostMapping
  @Tag(name = "create new person data", description = "This point create new person")
  public CreatePersonResponse createPerson(@RequestBody CreatePersonRequest request) {
    return createPersonUseCase.createPerson(request);
  }

  @PutMapping("/{id}")
  public UpdatePersonResponse updatePerson(
      @PathVariable Long id, @RequestBody UpdatePersonRequest userRequest) {
    return updatePersonUseCase.updatePersonById(id, userRequest);
  }

  @DeleteMapping("/{id}")
  @Tag(name = "delete person", description = "This point delete person")
  public void deletePerson(@PathVariable Long id) {
    deletePersonUseCase.deletePersonById(id);
  }
}
