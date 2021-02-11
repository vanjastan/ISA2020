package com.example.Pharmacy.service;

import com.example.Pharmacy.model.OrderFormOffers;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;

public interface OrderFormOffersService {
    List<OrderFormOffers> findAll() throws AccessDeniedException;

    OrderFormOffers findById(Long id);

    OrderFormOffers save(OrderFormOffers orderFormOffers);
}
