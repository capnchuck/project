package com.test.project.service;

import com.test.project.model.Person;

public interface IUserService {

    public Person findUserByUsername(String username);
    public Person saveUser(Person user, String role);
}