package com.test.project.repository;

import com.test.project.model.Club;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {

}

