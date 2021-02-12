package com.test.project;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.test.project.model.Club;
import com.test.project.model.Person;
import com.test.project.repository.ClubRepository;
import com.test.project.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClubTest {
    
    @Autowired
    private ClubRepository repository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void clubTest(){
        Club club = repository.save(new Club("club"));
        Person person = personRepository.save(new Person("Gary", "harry", "888-090-0900", "gary", "garyPassword", "Admin"));

        assertTrue(club.getMembers().size() == 0);
        club.getMembers().add(person);
        assertTrue(club.getMembers().size() == 1);
        assertTrue(club.getName() == "club");
    }
}
