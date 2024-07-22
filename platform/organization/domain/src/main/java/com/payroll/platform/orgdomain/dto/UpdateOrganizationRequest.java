package com.payroll.platform.orgdomain.dto;

public record UpdateOrganizationRequest(
    String kodOrganization, String name, String contact, String address) {}
