package com.payroll.platform.organization.boot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class OrganizationStarter {
  public static void main(String[] args) {
    SpringApplication.run(OrganizationStarter.class, args);
  }
}
