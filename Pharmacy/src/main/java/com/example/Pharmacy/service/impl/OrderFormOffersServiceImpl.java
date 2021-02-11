package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.OrderFormOffersDTO;
import com.example.Pharmacy.model.OrderFormOffers;
import com.example.Pharmacy.repository.OrderFormOffersRepository;
import com.example.Pharmacy.service.OrderFormOffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFormOffersServiceImpl implements OrderFormOffersService {

    @Autowired
    OrderFormOffersRepository orderFormOffersRepository;


    @Override
    public List<OrderFormOffers> findAll() throws AccessDeniedException{
        List<OrderFormOffers> result = orderFormOffersRepository.findAll();
        return result;
    }

    public OrderFormOffers findById(Long id) throws  AccessDeniedException{
        OrderFormOffers result = orderFormOffersRepository.findById(id).orElseGet(null);
        return result;
    }
}
