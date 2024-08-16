package com.payroll.platform.orginfra.adapter.driving.controller;

import com.payroll.platform.orgapp.port.in.CreateOrganizationUseCase;
import com.payroll.platform.orgapp.port.in.DeleteOrganizationUseCase;
import com.payroll.platform.orgapp.port.in.FindOrganizationByKodUseCase;
import com.payroll.platform.orgapp.port.in.FindOrganizationByOrganizationIdUseCase;
import com.payroll.platform.orgapp.port.in.UpdateOrganizationByIdUseCase;
import com.payroll.platform.orgdomain.dto.OrganizationId;
import com.payroll.platform.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.orgdomain.dto.UpdateOrganizationResponse;
import com.payroll.platform.orginfra.adapter.driven.persistence.repository.OrganizationAdapter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Organization management", description = "Endpoints for managing organization")
@RequiredArgsConstructor
@RestController
@RequestMapping("/organizations")
public class OrganizationController {
  private final FindOrganizationByOrganizationIdUseCase findOrganizationByOrganizationId;
  private final FindOrganizationByKodUseCase findOrganizationByKod;
  private final UpdateOrganizationByIdUseCase updateOrganizationById;
  private final DeleteOrganizationUseCase deleteOrganization;
  private final CreateOrganizationUseCase createOrganization;

  @GetMapping("/{id}")
  @Tag(name = "Get organization", description = "This endpoint get an organization by ID")
  public OrganizationResponse findOrganizationById(@PathVariable Long id) {
    return findOrganizationByOrganizationId.findOrganizationByIdUseCase(id);
  }

  @GetMapping("{/kod}")
  @Tag(
      name = "Get organization",
      description = "This endpoint get an organization by organization_kod")
  public OrganizationResponse findOrganizationByKod(@PathVariable String kod) {
    return findOrganizationByKod.findOrganizationByKodUseCase(kod);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Tag(name = "Create new organization", description = "This endpoint create an organization")
  public OrganizationResponse createOrganization(@RequestBody OrganizationRequest request) {
    return createOrganization.addOrganization(request);
  }

  @PutMapping("{/id}")
  public UpdateOrganizationResponse updateOrganization(
      @PathVariable Long id, @RequestBody UpdateOrganizationRequest request) {
    return updateOrganizationById.updateOrganization(id, request);
  }

  @DeleteMapping("{/id}")
  public void deleteOrganization(@PathVariable Long id) {
    deleteOrganization.deleteOrganizationById(new OrganizationId(id));
  }
}
