package com.payroll.platform.organization.orgdomain.dto;

public record UpdateOrganizationResponse(
    Long id, String kodOrganization, String name, String contact, String address) {}
