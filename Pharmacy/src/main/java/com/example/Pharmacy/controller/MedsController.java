package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.repository.MedsRepository;
import com.example.Pharmacy.service.impl.MedsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/meds")
public class MedsController {

    @Autowired
    private MedsServiceImpl medsImpl;

    @Autowired
    private MedsRepository medsRepo;

    @GetMapping("/all")
    public List<Meds> loadAllMeds() {return this.medsRepo.findAll(); }

    @PostMapping("/add_meds")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity addMeds(@RequestBody MedsDTO mdto) {
        medsImpl.addMeds(mdto);
        return ResponseEntity.ok().build();
    }


}
