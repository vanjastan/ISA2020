package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.RatingDermatologistDTO;
import com.example.Pharmacy.model.RatingDermatologist;
import com.example.Pharmacy.service.RatingDermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/ratingd")
public class RatingDermatologistController {

    @Autowired
    private RatingDermatologistService retDermatologistService;


    @GetMapping("/all")
    public ResponseEntity<List<RatingDermatologistDTO>> getAll(){
        List<RatingDermatologist> d = retDermatologistService.findAll();

        List<RatingDermatologistDTO> dto = new ArrayList<>();

        for(RatingDermatologist e : d){
            dto.add(new RatingDermatologistDTO(e));
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{derm_id}")
    public ResponseEntity<List<RatingDermatologistDTO>> getRate(@PathVariable("derm_id") Long derm_id){
        List<RatingDermatologist> d = retDermatologistService.findAll();

        List<RatingDermatologistDTO> dto = new ArrayList<>();

        for(RatingDermatologist r : d){
            if(r.getDermatologist().getId() == derm_id){
                dto.add(new RatingDermatologistDTO(r));
            }
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
