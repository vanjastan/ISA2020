package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.RatingDermatologistDTO;
import com.example.Pharmacy.dto.RatingPharmacistDTO;
import com.example.Pharmacy.model.RatingDermatologist;
import com.example.Pharmacy.model.RatingPharmacist;
import com.example.Pharmacy.service.RatingPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/rating")
public class RatingPharmacistController {

    @Autowired
    private RatingPharmacistService retRatingPharmacistService;

    @CrossOrigin
    @GetMapping(value = "/{ph_id}")
    public ResponseEntity<List<RatingPharmacistDTO>> getRate(@PathVariable("ph_id") Long ph_id){
        List<RatingPharmacist> d = retRatingPharmacistService.findAll();

        List<RatingPharmacistDTO> dto = new ArrayList<>();

        for(RatingPharmacist r : d){
            if(r.getPharmacist().getId() == ph_id){
                dto.add(new RatingPharmacistDTO(r));
            }
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
