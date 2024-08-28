package com.payroll.platform.user.userboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.payroll.platform.user")
@EnableJpaRepositories(basePackages = "com.payroll.platform.user")
@EntityScan(basePackages = "com.payroll.platform.user")
public class UserStarter {

  public static void main(String[] args) {
    SpringApplication.run(UserStarter.class, args);
  }
}
