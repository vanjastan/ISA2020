package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ActionsAndPromotionsDTO;
import com.example.Pharmacy.model.ActionsAndPromotions;
import com.example.Pharmacy.service.ActionsAndPromotionsService;
import com.example.Pharmacy.service.impl.ActionsAndPromotionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/actions")
public class ActionsAndPromotionsController {

    @Autowired
    private ActionsAndPromotionsService actionsAndPromotionsService;

    @Autowired
    ActionsAndPromotionsServiceImpl actionsAndPromotionsServiceimpl;

    @GetMapping("/all")
    public List<ActionsAndPromotions> loadAll(){
        return this.actionsAndPromotionsService.findAll();
    }

    @PostMapping("/addActionPromotion")
    public ResponseEntity addActionPromotion(@RequestBody ActionsAndPromotionsDTO dto) {
        actionsAndPromotionsServiceimpl.addActions(dto);
        return ResponseEntity.ok().build();
    }

}
