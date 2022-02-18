package com.braga.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braga.workshop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
