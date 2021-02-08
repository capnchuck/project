package com.test.project.controller;

import com.test.project.exception.ClubNotFoundException;
import com.test.project.model.Club;
import com.test.project.repository.ClubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("v1")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/get-club/{clubId}")
    Club all(@PathVariable long clubId){

      var club = clubRepository.findById(clubId) //
      .orElseThrow(() -> new ClubNotFoundException(clubId));

      return club;
    }

    @PostMapping("/post-club")
    Club createClub(@RequestBody Club club) {
      return clubRepository.save(club);
    }

    @DeleteMapping("/delete-club/{clubId}")
    void deleteAddress(@PathVariable Long clubId) {
      clubRepository.deleteById(clubId);
    }
}