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
  CommandLineRunner initDatabase(PersonRepository repository, AddressRepository addressRepository) {

    return args -> {
      var person = repository.save(new Person("Hero", "Failure", "801-000-0000"));
      var person2 = repository.save(new Person("John", "Light", "801-000-1111"));
      var person3 = repository.save(new Person("Calvin", "Shirt", "801-000-2222"));
      var person4 = repository.save(new Person("Billy", "Papers", "801-000-3333"));
      var person5 = repository.save(new Person("Scary", "Terry", "801-000-4444"));

      var address = addressRepository.save(new Address("123 N 456 S", "American Fork", "Utah", "84003"));
      var address2 = addressRepository.save(new Address("321 N 654 S", "American Fork", "Utah", "84003"));
      var address3 = addressRepository.save(new Address("123 N 456 S", "American Fork3", "Utah", "84003"));
      var address4 = addressRepository.save(new Address("321 N 654 S", "American Fork4", "Utah", "84003"));
      var address5 = addressRepository.save(new Address("123 N 456 S", "American Fork5", "Utah", "84003"));
      var address6 = addressRepository.save(new Address("321 N 654 S", "American Fork6", "Utah", "84003"));
      var address7 = addressRepository.save(new Address("123 N 456 S", "American Fork7", "Utah", "84003"));
      var address8 = addressRepository.save(new Address("321 N 654 S", "American Fork8", "Utah", "84003"));

      address.setPerson(person);
      address2.setPerson(person);
      address3.setPerson(person2);
      address4.setPerson(person3);
      address5.setPerson(person4);
      address6.setPerson(person5);
      address7.setPerson(person5);
      address8.setPerson(person5);

      addressRepository.save(address);
      addressRepository.save(address2);
      addressRepository.save(address3);
      addressRepository.save(address4);
      addressRepository.save(address5);
      addressRepository.save(address6);
      addressRepository.save(address7);
      addressRepository.save(address8);
    };
  }
}