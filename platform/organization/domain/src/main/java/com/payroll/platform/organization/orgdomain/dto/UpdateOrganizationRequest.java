package com.payroll.platform.organization.orgdomain.dto;

public record UpdateOrganizationRequest(
    String kodOrganization, String name, String telephoneNumber, String address) {}
