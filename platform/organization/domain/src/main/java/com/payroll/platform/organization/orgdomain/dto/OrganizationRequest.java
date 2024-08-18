package com.payroll.platform.organization.orgdomain.dto;

public record OrganizationRequest(
    Long id, String kodOrganization, String name, String contact, String address) {}
