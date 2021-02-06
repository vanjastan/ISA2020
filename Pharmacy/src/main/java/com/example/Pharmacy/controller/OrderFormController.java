package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.OrderFormDTO;
import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.repository.OrderFormRepository;
import com.example.Pharmacy.service.impl.OrderFormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity addOrderForm(@RequestBody OrderFormDTO dto) {
        orderFormService.addOrderForm(dto);
        return ResponseEntity.ok().build();
    }

}
