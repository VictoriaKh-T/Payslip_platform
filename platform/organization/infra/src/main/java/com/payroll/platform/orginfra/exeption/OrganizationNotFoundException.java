package com.payroll.platform.orginfra.exeption;

import java.util.function.Supplier;

public class OrganizationNotFoundException extends RuntimeException{
    public OrganizationNotFoundException (String message) {
        super(message);
    }

    public static Supplier<OrganizationNotFoundException> supplier(String message) {
        return () -> new OrganizationNotFoundException(message);
    }
}
