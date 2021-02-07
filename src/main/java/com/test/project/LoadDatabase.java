package com.test.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PersonRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Person("Hero", "Failure", "801-000-0000")));
      // log.info("Preloading " + repository.save(new Person("John", "Light", "801-000-1111")));
      // log.info("Preloading " + repository.save(new Person("Calvin", "Shirt", "801-000-2222")));
      // log.info("Preloading " + repository.save(new Person("Billy", "Papers", "801-000-3333")));
      // log.info("Preloading " + repository.save(new Person("Scary", "Terry", "801-000-4444")));
    };
  }
}