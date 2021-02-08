package com.test.project.controller;

import com.test.project.exception.AddressNotFoundException;
import com.test.project.exception.PersonNotFoundException;
import com.test.project.model.Address;
import com.test.project.repository.AddressRepository;
import com.test.project.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("v1")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person/{personId}/get-address/{id}")
    Address all(@PathVariable long personId, @PathVariable long id){

      personRepository.findById(personId) //
      .orElseThrow(() -> new PersonNotFoundException(personId));
      
      var address = addressRepository.findById(id) //
      .orElseThrow(() -> new AddressNotFoundException(id));

      return address;
    }

    @PostMapping("/person/{personId}/post-address")
    Address createAddress(@PathVariable (value = "personId") Long personId,
                                 @RequestBody Address address) {
      var person = personRepository.findById(personId)
      .orElseThrow(() -> new PersonNotFoundException(personId));
      address.setPerson(person);
      return addressRepository.save(address);
    }

    @DeleteMapping("/person/{personId}/delete-address/{id}")
    void deleteAddress(@PathVariable Long personId, @PathVariable Long id) {
      addressRepository.deleteById(id);
    }
}