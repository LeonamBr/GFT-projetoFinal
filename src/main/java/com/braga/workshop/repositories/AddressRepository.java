package com.braga.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braga.workshop.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
