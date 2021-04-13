package com.cafeteriaexpreess.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafeteriaexpreess.order.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
