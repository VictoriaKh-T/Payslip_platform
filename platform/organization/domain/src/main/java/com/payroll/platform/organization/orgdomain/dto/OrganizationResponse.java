package com.payroll.platform.organization.orgdomain.dto;

public record OrganizationResponse(
        Long id, String kodOrganization, String name, String telephoneNumber, String address) {}
