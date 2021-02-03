package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Medicament;
import com.example.Pharmacy.repository.MedicamentRepository;
import com.example.Pharmacy.service.MedicamentService;
import com.example.Pharmacy.service.impl.MedicamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/medicament")
public class MedicamentController {

    @Autowired
    private MedicamentServiceImpl medicament;

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Autowired
    private MedicamentService medicamentService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Medicament> loadAllMedicaments() {
        return this.medicamentRepository.findAll();
    }

    @GetMapping("/{name}")
    public Medicament loadByName(@PathVariable String name) {
        return this.medicamentService.findByName(name);
    }

}
