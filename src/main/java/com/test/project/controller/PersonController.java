package com.test.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.test.project.exception.PersonNotFoundException;
import com.test.project.model.Person;
import com.test.project.repository.PersonRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("v1")
class PersonController {

  @Autowired
  private PersonRepository repository;

  PersonController(PersonRepository repository) {

    this.repository = repository;
  }

  @GetMapping("/get-person/{personId}")
  Person one(@PathVariable Long personId) {
  
    Person person = repository.findById(personId) //
        .orElseThrow(() -> new PersonNotFoundException(personId));
  
    return person;
  }

  @PostMapping("/post-person")
  Person newPerson(@RequestBody Person person) {
    return repository.save(person);
  }
  
  @DeleteMapping("/delete-person/{personId}")
  void deletePerson(@PathVariable Long personId) {
    repository.deleteById(personId);
  }
}