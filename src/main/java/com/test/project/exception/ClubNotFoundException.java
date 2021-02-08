package com.test.project.exception;

public class ClubNotFoundException extends RuntimeException {

  public ClubNotFoundException(Long id) {
      super("Could not find any club with the id " + id);
    }
  }
