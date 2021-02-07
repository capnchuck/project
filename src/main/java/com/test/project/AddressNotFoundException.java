package com.test.project;

class AddressNotFoundException extends RuntimeException {

  AddressNotFoundException(Long id) {
      super("Could not find any address with the id " + id);
    }
  }
