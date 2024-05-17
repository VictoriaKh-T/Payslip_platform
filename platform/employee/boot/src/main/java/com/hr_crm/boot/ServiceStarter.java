package com.hr_crm.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hr_crm")
public class ServiceStarter {
  public static void main(String[] args) {
    SpringApplication.run(ServiceStarter.class, args);
  }
}
