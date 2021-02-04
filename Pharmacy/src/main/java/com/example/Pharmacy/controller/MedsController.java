package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.repository.MedsRepository;
import com.example.Pharmacy.service.MedsService;
import com.example.Pharmacy.service.impl.MedsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private MedsService medsService;

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

    @RequestMapping(value="/forPatient/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<Meds> findMedsByPatientId(@PathVariable("id") Long id) {
        List<Meds> reservedMeds = medsService.findByPatientId(id);
        return reservedMeds;
    }

    @RequestMapping(value="/cancel/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Meds> cancelMed(@PathVariable("id") Long id){
        Meds med = medsService.findById(id);
        med.setPatient(null);
        med = medsService.save(med);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
