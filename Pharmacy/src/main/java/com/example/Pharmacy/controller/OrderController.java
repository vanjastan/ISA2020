package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.OrderDTO;
import com.example.Pharmacy.model.Order;
import com.example.Pharmacy.repository.OrderRepository;
import com.example.Pharmacy.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/urgentOrder")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Order> loadAllOrders() {
        return this.orderRepository.findAll();
    }

    @PostMapping("/forMedicament")
    public ResponseEntity saveOrder(@RequestBody OrderDTO orderDTO){
        orderServiceImpl.saveOrder(orderDTO);
        return ResponseEntity.ok().build();
    }


}