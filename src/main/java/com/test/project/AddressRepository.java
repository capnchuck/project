package com.test.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByPersonId(@Param("person_id")Long personId);
}

