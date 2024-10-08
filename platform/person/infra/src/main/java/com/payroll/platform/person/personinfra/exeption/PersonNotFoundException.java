package com.payroll.platform.person.personinfra.exeption;

import java.util.function.Supplier;

public class PersonNotFoundException extends RuntimeException {
  public PersonNotFoundException(String message) {
    super(message);
  }

  public static Supplier<PersonNotFoundException> supplier(String message) {
    return () -> new PersonNotFoundException(message);
  }
}
