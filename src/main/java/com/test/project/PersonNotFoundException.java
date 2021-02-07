package com.test.project;

class PersonNotFoundException extends RuntimeException {

    PersonNotFoundException(Long id) {
      super("Could not find any member with the id " + id);
    }
  }
