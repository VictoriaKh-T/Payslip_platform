package com.payroll.platform.user.userinfra.exeption;

import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }

  public static Supplier<UserNotFoundException> supplier(String message) {
    return () -> new UserNotFoundException(message);
  }
}
