package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.repository.OrderFormRepository;
import com.example.Pharmacy.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    OrderFormRepository orderFormRepository;

    @Override
    public List<OrderForm> findAll() throws AccessDeniedException{
        List<OrderForm> result = orderFormRepository.findAll();
        return result;
    }
}
