package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ActionsAndPromotionsDTO;
import com.example.Pharmacy.model.ActionsAndPromotions;
import com.example.Pharmacy.model.Subscribed;
import com.example.Pharmacy.service.ActionsAndPromotionsService;
import com.example.Pharmacy.service.SubscribedService;
import com.example.Pharmacy.service.impl.ActionsAndPromotionsServiceImpl;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/actions")
public class ActionsAndPromotionsController {

    @Autowired
    private ActionsAndPromotionsService actionsAndPromotionsService;

    @Autowired
    EmailServiceImpl emailServiceImpl;


    @Autowired
    SubscribedService service;

    @Autowired
    ActionsAndPromotionsServiceImpl actionsAndPromotionsServiceimpl;

    @GetMapping("/all")
    public List<ActionsAndPromotions> loadAll(){

        return this.actionsAndPromotionsService.findAll();
    }

    @PostMapping("/addActionPromotion")
    @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity addActionPromotion(@RequestBody ActionsAndPromotionsDTO dto) throws MessagingException {
        actionsAndPromotionsServiceimpl.addActions(dto);
        List<Subscribed> aa = service.findAll();

        for(Subscribed subscribed:aa){
           emailServiceImpl.sendActionsNotifications(subscribed);
        }

        return ResponseEntity.ok().build();
    }
}
