package com.test.project;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.test.project.model.Address;
import com.test.project.model.Person;
import com.test.project.repository.AddressRepository;
import com.test.project.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressTest {
    
    @Autowired
    private AddressRepository repository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void addressTest(){
        Address address = repository.save(new Address("123 N 456 S", "American Fork", "Utah", "84003"));
        Person person = personRepository.save(new Person("Gary", "harry", "888-090-0900", "gary", "garyPassword", "Admin"));

        assertTrue(address.getAddress() == "123 N 456 S");
        assertTrue(address.getCity() == "American Fork");
        assertTrue(address.getState() == "Utah");
        assertTrue(address.getZipCode() == "84003");

        address.setPerson(person);
        assertTrue(address.getPerson() == person);
    }
}
