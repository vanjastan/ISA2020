package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.ActionsAndPromotions;
import com.example.Pharmacy.service.ActionsAndPromotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/actions", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActionsAndPromotionsController {

    @Autowired
    private ActionsAndPromotionsService actionsAndPromotionsService;

    @GetMapping("/all")
    public List<ActionsAndPromotions> loadAll(){
        return this.actionsAndPromotionsService.findAll();
    }

    @PostMapping(value = "/addAction")
    public ResponseEntity<ActionsAndPromotions> addSala(@RequestBody ActionsAndPromotions ap) {
        //salaService.updateSala(sala);
        return new ResponseEntity<ActionsAndPromotions>(ap, HttpStatus.OK);
    }


}
