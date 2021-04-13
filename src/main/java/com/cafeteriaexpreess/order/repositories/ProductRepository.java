package com.cafeteriaexpreess.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafeteriaexpreess.order.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
 
}
