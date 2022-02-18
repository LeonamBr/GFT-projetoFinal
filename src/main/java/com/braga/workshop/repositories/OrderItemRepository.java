package com.braga.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braga.workshop.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
