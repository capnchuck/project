package com.test.project.controller;

import com.test.project.exception.ClubNotFoundException;
import com.test.project.model.Club;
import com.test.project.repository.ClubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("v1")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @PreAuthorize("hasAnyRole('ROLE_User', 'ROLE_Admin')")
    @GetMapping("/get-club/{clubId}")
    Club all(@PathVariable long clubId){

      var club = clubRepository.findById(clubId) //
      .orElseThrow(() -> new ClubNotFoundException(clubId));

      return club;
    }

    @PreAuthorize("hasRole('ROLE_Admin')")
    @PostMapping("/post-club")
    Club createClub(@RequestBody Club club) {
      return clubRepository.save(club);
    }

    @PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("/delete-club/{clubId}")
    String deleteClub(@PathVariable Long clubId) {
      Club club = clubRepository.findById(clubId) 
      .orElseThrow(() -> new ClubNotFoundException(clubId));

      clubRepository.delete(club);
      return "success";
    }
}