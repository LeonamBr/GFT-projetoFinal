package com.braga.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braga.workshop.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
