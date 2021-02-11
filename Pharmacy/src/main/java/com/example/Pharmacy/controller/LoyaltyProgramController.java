package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.LoyaltyProgramDTO;
import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.model.LoyaltyProgram;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/loyalty")
public class LoyaltyProgramController {

    @Autowired
    private LoyaltyProgramService loyaltyProgramService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<LoyaltyProgramDTO>> getAllPrograms() {

        List<LoyaltyProgram> programs = loyaltyProgramService.findAll();

        List<LoyaltyProgramDTO> programsDTO = new ArrayList<>();
        for (LoyaltyProgram l : programs) {
            programsDTO.add(new LoyaltyProgramDTO(l));
        }

        return new ResponseEntity<>(programsDTO, HttpStatus.OK);
    }
}
