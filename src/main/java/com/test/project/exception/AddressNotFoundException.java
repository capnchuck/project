package com.test.project.exception;

public class AddressNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public AddressNotFoundException(Long id) {
      super("Could not find any address with the id " + id);
    }
  }
