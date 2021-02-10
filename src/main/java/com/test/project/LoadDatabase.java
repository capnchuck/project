package com.test.project;

import com.test.project.model.Address;
import com.test.project.model.Club;
import com.test.project.model.Person;
import com.test.project.model.Role;
import com.test.project.repository.AddressRepository;

import com.test.project.repository.ClubRepository;
import com.test.project.repository.PersonRepository;
import com.test.project.repository.RoleRepository;
import com.test.project.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(PersonRepository repository, AddressRepository addressRepository, ClubRepository clubRepository, RoleRepository roleRepository, UserServiceImpl userService) {

    return args -> {

      var role = roleRepository.save(new Role());
      role.setRole("Admin");
      var role2 = roleRepository.save(new Role());
      role2.setRole("User");

      var person = userService.saveUser(new Person("Hero", "Failure", "801-000-0000", "hero1", "heee"), "Admin");
      var person2 = userService.saveUser(new Person("John", "Light", "801-000-1111", "hero2", "heas"), "User");
      var person3 = userService.saveUser(new Person("Calvin", "Shirt", "801-000-2222", "hero2", "hease"), "User");
      var person4 = userService.saveUser(new Person("Billy", "Papers", "801-000-3333", "hero3", "heros"), "User");
      var person5 = userService.saveUser(new Person("Scary", "Terry", "801-000-4444", "hero4", "heroos"), "User");

      var address = addressRepository.save(new Address("123 N 456 S", "American Fork", "Utah", "84003"));
      var address2 = addressRepository.save(new Address("321 N 654 S", "American Fork", "Utah", "84003"));
      var address3 = addressRepository.save(new Address("123 N 456 S", "American Fork3", "Utah", "84003"));
      var address4 = addressRepository.save(new Address("321 N 654 S", "American Fork4", "Utah", "84003"));
      var address5 = addressRepository.save(new Address("123 N 456 S", "American Fork5", "Utah", "84003"));
      var address6 = addressRepository.save(new Address("321 N 654 S", "American Fork6", "Utah", "84003"));
      var address7 = addressRepository.save(new Address("123 N 456 S", "American Fork7", "Utah", "84003"));
      var address8 = addressRepository.save(new Address("321 N 654 S", "American Fork8", "Utah", "84003"));

      var club = clubRepository.save(new Club("Hey Club"));
      var club2 = clubRepository.save(new Club("Club 2"));
      var club3 = clubRepository.save(new Club("Club 3"));

      
      club.getMembers().add(person);
      club.getMembers().add(person2);
      club.getMembers().add(person3);
      club2.getMembers().add(person);
      club2.getMembers().add(person4);
      club3.getMembers().add(person5);

      clubRepository.save(club);
      clubRepository.save(club2);
      clubRepository.save(club3);
      
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