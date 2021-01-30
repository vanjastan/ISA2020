package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.repository.OrderFormRepository;
import com.example.Pharmacy.service.impl.OrderFormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orderform")
public class OrderFormController {

    @Autowired
    private OrderFormServiceImpl orderFormService;

    @Autowired
    private OrderFormRepository orderFormRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<OrderForm> loadAllOrderForms(){return  this.orderFormRepository.findAll();}
}
