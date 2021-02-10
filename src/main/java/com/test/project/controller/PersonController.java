package com.test.project.controller;

import com.test.project.exception.PersonNotFoundException;
import com.test.project.model.Club;
import com.test.project.model.Person;
import com.test.project.repository.ClubRepository;
import com.test.project.repository.PersonRepository;
import com.test.project.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController 
@RequestMapping("v1")
class PersonController {

  @Autowired
  private PersonRepository repository;

  @Autowired
  private ClubRepository clubRepository;

  @Autowired
  private UserServiceImpl userService;

  PersonController(PersonRepository repository, ClubRepository clubRepository, UserServiceImpl userService) {

    this.repository = repository;
    this.clubRepository = clubRepository;
    this.userService = userService;
  }

  @GetMapping("/login")
  public String login() {

    return "Failure";
  }


  @GetMapping("/get-person/{personId}")
  Person one(@PathVariable Long personId) {
  
    Person person = repository.findById(personId) //
        .orElseThrow(() -> new PersonNotFoundException(personId));
  
    return person;
  }

  @PostMapping("/post-person")
  Person newPerson(@RequestBody Person person) {
    return userService.saveUser(person, "User");
  }
  
  @DeleteMapping("/delete-person/{personId}")
  void deletePerson(@PathVariable Long personId) {
    Person person = repository.findById(personId) //
        .orElseThrow(() -> new PersonNotFoundException(personId));

    var clubs = clubRepository.findAll();

    for(Club club : clubs){
      if (club.getMembers().contains(person)){
        club.getMembers().remove(person);
      }
    }

    repository.delete(person);
  }
}