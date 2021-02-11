package com.example.Pharmacy.service;

import com.example.Pharmacy.model.OrderForm;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface OrderFormService {
    List<OrderForm> findAll() throws AccessDeniedException;

    OrderForm save(OrderForm orderForm);

    OrderForm findById(Long id);

    void delete(Long id);
}
