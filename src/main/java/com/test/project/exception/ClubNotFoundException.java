package com.test.project.exception;

public class ClubNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ClubNotFoundException(Long id) {
      super("Could not find any club with the id " + id);
    }
  }
