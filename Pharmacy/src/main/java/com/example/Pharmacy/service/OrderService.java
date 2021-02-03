package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findByName(String name);
}

