package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.PricelistDTO;
import com.example.Pharmacy.mappers.PricelistMapper;

import com.example.Pharmacy.model.Pricelist;
import com.example.Pharmacy.service.PharmacyService;
import com.example.Pharmacy.service.PricelistService;
import com.example.Pharmacy.service.impl.PricelistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/pricelist")
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    PricelistServiceImpl pricelistServiceImpl;

    @Autowired
    private PharmacyService pharmacyService;


    @GetMapping("/all")
    public ResponseEntity<List<PricelistDTO>> getPricelist(){
       List<Pricelist> pricelists = pricelistService.findAll();

       List<PricelistDTO> pricelistDTO = new ArrayList<>();

       for(Pricelist p : pricelists){
           pricelistDTO.add(new PricelistDTO(p));
       }

       return new ResponseEntity<>(pricelistDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{pharmacy_id}")
    @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity<List<PricelistDTO>> getPLByPharmacyId(@PathVariable("pharmacy_id") Long pharmacy_id){
        List<Pricelist> pricelists = pricelistService.findAll();

        List<PricelistDTO> pricelist = new ArrayList<>();

        for(Pricelist p : pricelists){
            if(p.getPharm().getId() == pharmacy_id){
                pricelist.add(new PricelistDTO(p));
            }
        }

        return new ResponseEntity<>(pricelist, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "editPricelist")
    @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity<PricelistDTO> editPricelist (@RequestBody PricelistDTO dto){
        Pricelist pricelistInfo = pricelistService.findById(dto.getId());

        if(pricelistInfo == null){
            return null;
        }

        pricelistInfo.setPrice(dto.getPrice());
        pricelistInfo.setFrom_date(dto.getFrom_date());
        pricelistInfo.setTo_date(dto.getTo_date());

        pricelistInfo = pricelistService.save(pricelistInfo);

        return new ResponseEntity<>(PricelistMapper.toDTO(pricelistInfo), HttpStatus.OK);
    }

}