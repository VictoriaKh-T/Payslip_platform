package com.payroll.platform.organization.orginfra.adapter.driving.controller;

import com.payroll.platform.organization.orgapp.port.in.CreateOrganizationUseCase;
import com.payroll.platform.organization.orgapp.port.in.DeleteOrganizationUseCase;
import com.payroll.platform.organization.orgapp.port.in.FindAllOrganizationsUseCase;
import com.payroll.platform.organization.orgapp.port.in.FindOrganizationByKodUseCase;
import com.payroll.platform.organization.orgapp.port.in.FindOrganizationByOrganizationIdUseCase;
import com.payroll.platform.organization.orgapp.port.in.UpdateOrganizationByIdUseCase;
import com.payroll.platform.organization.orgdomain.dto.OrganizationId;
import com.payroll.platform.organization.orgdomain.dto.OrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.OrganizationResponse;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationRequest;
import com.payroll.platform.organization.orgdomain.dto.UpdateOrganizationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
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
@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {
  private final FindOrganizationByOrganizationIdUseCase findOrganizationByOrganizationId;
  private final FindOrganizationByKodUseCase findOrganizationByKod;
  private final UpdateOrganizationByIdUseCase updateOrganizationById;
  private final DeleteOrganizationUseCase deleteOrganization;
  private final CreateOrganizationUseCase createOrganization;
  private final FindAllOrganizationsUseCase findAllOrganizations;

  @GetMapping
  @Tag(name = "Get organizations", description = "This endpoint get all organizations")
  public List<OrganizationResponse> findAllOrganizations() {
    return findAllOrganizations.findAll();
  }

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
