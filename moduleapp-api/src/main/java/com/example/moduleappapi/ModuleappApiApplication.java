package com.example.moduleappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.moduleappcommon.repository")
@EntityScan(basePackages = "com.example.moduleappcommon.model")
@ComponentScan(basePackages = {"com.example.moduleappapi.*",
  "com.example.moduleappcommon.*"})public class ModuleappApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ModuleappApiApplication.class, args);
  }

}
