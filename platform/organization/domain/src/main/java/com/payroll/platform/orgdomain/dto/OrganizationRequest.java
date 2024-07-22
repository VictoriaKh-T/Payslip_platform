package com.payroll.platform.orgdomain.dto;

public record OrganizationRequest(
    String kodOrganization, String name, String contact, String address) {}
