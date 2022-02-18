package com.braga.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braga.workshop.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
