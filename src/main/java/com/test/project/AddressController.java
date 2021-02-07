package com.test.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("v1")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person/{personId}/addresses")
    List<Address> all(@PathVariable long personId){

      personRepository.findById(personId) //
      .orElseThrow(() -> new PersonNotFoundException(personId));
      
      var addresses = addressRepository.findByPersonId(personId);

      return addresses;
    }

    @GetMapping("/person/{personId}/addresses/{id}")
    Address all(@PathVariable long personId, @PathVariable long id){

      personRepository.findById(personId) //
      .orElseThrow(() -> new PersonNotFoundException(personId));
      
      var address = addressRepository.findById(id) //
      .orElseThrow(() -> new AddressNotFoundException(id));

      return address;
    }

    @PostMapping("/person/{personId}/addresses/post-address")
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