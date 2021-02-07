package com.test.project;

class ClubNotFoundException extends RuntimeException {

  ClubNotFoundException(Long id) {
      super("Could not find any club with the id " + id);
    }
  }
