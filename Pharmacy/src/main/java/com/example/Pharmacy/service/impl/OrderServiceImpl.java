package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.OrderDTO;
import com.example.Pharmacy.model.Order;
import com.example.Pharmacy.repository.OrderRepository;
import com.example.Pharmacy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() throws AccessDeniedException {
        List<Order> result = orderRepository.findAll();
        return result;
    }

    @Override
    public Order findByName(String name) {
        return null;
    }

    public Order saveOrder(OrderDTO orderDTO){
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setName(orderDTO.getName());
        order.setQuantity(orderDTO.getQuantity());

        order = this.orderRepository.save(order);
        return order;
    }
}
