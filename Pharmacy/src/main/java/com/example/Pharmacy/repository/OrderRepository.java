package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByName(String name);
}

