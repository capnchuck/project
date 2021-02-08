package com.test.project.exception;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id) {
      super("Could not find any member with the id " + id);
    }
  }
