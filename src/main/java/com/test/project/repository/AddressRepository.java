package com.test.project.repository;

import java.util.List;

import com.test.project.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByPersonId(@Param("person_id")Long personId);
}

