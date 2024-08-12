package com.payroll.platform.orginfra.adapter.driving.controller;

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
    private final OrganizationAdapter adapter;

    @GetMapping("/{id}")
    @Tag(name = "Get organization",
            description = "This endpoint get an organization by ID")
    public OrganizationResponse findOrganizationById(@PathVariable Long id) {
        return adapter.findByOrganizationId(new OrganizationId(id));
        // change to Long id instant of OrganizationId
    }

    @GetMapping("{/kod}")
    @Tag(name = "Get organization",
            description = "This endpoint get an organization by organization_kod")
    public OrganizationResponse findOrganizationByKod (@PathVariable String kod) {
        return adapter.findByOrganizationKod(kod);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Tag(name = "Create new organization",
            description = "This endpoint create an organization")
    public  OrganizationResponse createOrganization(@RequestBody OrganizationRequest request) {
        return adapter.addOrganization(request);
    }

    @PutMapping("{/id}")
    public UpdateOrganizationResponse updateOrganization(@PathVariable Long id,
                                                         @RequestBody UpdateOrganizationRequest request) {
        return adapter.updateOrganizationById(id, request);
    }

    @DeleteMapping("{/id}")
    public void deleteOrganization (@PathVariable Long id) {
        adapter.deleteOrganizationById(new OrganizationId(id));
    }

}
