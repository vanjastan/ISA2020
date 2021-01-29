package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Pharmacies> loadAllPh() {return this.pharmacyRepository.findAll();}
}
