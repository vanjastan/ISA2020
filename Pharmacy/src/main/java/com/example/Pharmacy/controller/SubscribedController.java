package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.SubscribedDTO;
import com.example.Pharmacy.model.Subscribed;
import com.example.Pharmacy.service.SubscribedService;
import com.example.Pharmacy.service.impl.SubscribedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/subscribed")
public class SubscribedController {

    @Autowired
    SubscribedServiceImpl subscribed;

    @Autowired
    private SubscribedService subscribedService;

    @GetMapping("/all")
    public List<Subscribed> loadAll(){
        return this.subscribedService.findAll();
    }

    @PostMapping("/addEmail")
    public ResponseEntity addSubEmail(@RequestBody SubscribedDTO dto){
        subscribed.addEmails(dto);
        return ResponseEntity.ok().build();
    }
}
