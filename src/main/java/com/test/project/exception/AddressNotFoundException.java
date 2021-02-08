package com.test.project.exception;

public class AddressNotFoundException extends RuntimeException {

  public AddressNotFoundException(Long id) {
      super("Could not find any address with the id " + id);
    }
  }
