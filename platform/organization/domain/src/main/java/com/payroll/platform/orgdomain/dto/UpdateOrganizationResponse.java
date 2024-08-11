package com.payroll.platform.orgdomain.dto;

public record UpdateOrganizationResponse(
    Long id, String kodOrganization, String name, String contact, String address) {}
