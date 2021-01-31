package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.PharmaciesDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.PharmacyRepository;
import com.example.Pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private PharmacyService pharmacyService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Pharmacies> loadAllPh() {return this.pharmacyRepository.findAll();}

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Pharmacies loadPhById(@PathVariable Long id){
        return this.pharmacyService.findById(id);
    }
}
