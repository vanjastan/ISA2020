package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.HospitalDTO;
import com.example.Pharmacy.model.Hospital;
import com.example.Pharmacy.repository.HospitalRepository;
import com.example.Pharmacy.service.impl.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/hospitals")
public class HospitalController {

    @Autowired
    private HospitalServiceImpl hospital;

    @Autowired
    private HospitalRepository hospitalRepository;

    @GetMapping("/hospital/all")
    public List<Hospital> loadAllHospitals() {return this.hospitalRepository.findAll(); }

    @PostMapping("/hospital/add_hospital")
    public ResponseEntity addHospital(@RequestBody HospitalDTO hdto) {
        hospital.addHospital(hdto);
        return ResponseEntity.ok().build();
    }
}
