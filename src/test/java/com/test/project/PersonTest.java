package com.test.project;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.test.project.model.Person;
import com.test.project.service.UserServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PersonTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void personTest() {
        Person person = userService.saveUser(new Person("Gary", "harry", "888-090-0900", "gary", "garyPassword", "Admin"));

        assertTrue(person.getUsername() == "gary");
        assertFalse(person.getPassword() == "garyPassword");
        assertTrue(bCryptPasswordEncoder.matches("garyPassword", person.getPassword()));

        assertTrue(person.getPersonalInfo().getFirstName() == "Gary");
        assertTrue(person.getPersonalInfo().getLastName() == "harry");
        assertTrue(person.getPersonalInfo().getPhoneNumber() == "888-090-0900");
        assertTrue(person.getRole() == "Admin");
    }
}
