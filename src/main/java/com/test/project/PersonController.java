package com.test.project;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
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

  private final PersonRepository repository;
  private final PersonModelAssembler assembler;

  PersonController(PersonRepository repository, PersonModelAssembler assembler) {

    this.repository = repository;
    this.assembler = assembler;
  }

  // TODO REMOVE ME
  @GetMapping("/persons")
  CollectionModel<EntityModel<Person>> all() {
  
    List<EntityModel<Person>> persons = repository.findAll().stream() //
        .map(assembler::toModel) //
        .collect(Collectors.toList());
  
    return CollectionModel.of(persons, linkTo(methodOn(PersonController.class).all()).withSelfRel());
  }

  @PostMapping("/post-person")
  Person newPerson(@RequestBody Person person) {
    return repository.save(person);
  }
  
  @GetMapping("/get-person/{personId}")
  EntityModel<Person> one(@PathVariable Long personId) {
  
    Person person = repository.findById(personId) //
        .orElseThrow(() -> new PersonNotFoundException(personId));
  
    return EntityModel.of(person, //
        linkTo(methodOn(PersonController.class).one(personId)).withSelfRel(),
        linkTo(methodOn(PersonController.class).all()).withRel("persons"));
  }

  
  // @GetMapping("/get-person/{personId}")
  // String one(@PathVariable Long personId) {
  
  //   Person person = repository.findById(personId) //
  //       .orElseThrow(() -> new PersonNotFoundException(personId));
  
  //   return person.toString();
  // }

  @DeleteMapping("/delete-person/{personId}")
  void deletePerson(@PathVariable Long personId) {
    repository.deleteById(personId);
  }
}