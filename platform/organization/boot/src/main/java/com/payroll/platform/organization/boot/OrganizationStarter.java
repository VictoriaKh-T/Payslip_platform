package com.payroll.platform.organization.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.payroll.platform.organization")
@EnableJpaRepositories(basePackages = "com.payroll.platform.organization")
@EntityScan(basePackages = "com.payroll.platform.organization")
public class OrganizationStarter {
  public static void main(String[] args) {
    SpringApplication.run(OrganizationStarter.class, args);
  }
}
