package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.ExaminationPh;
import com.example.Pharmacy.repository.ExaminationPhRepository;
import com.example.Pharmacy.service.ExaminationPhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/examinationsPh")
public class ExaminationPhController {

    @Autowired
    ExaminationPhRepository examinationPhRepository;

    @Autowired
    ExaminationPhService examinationPhService;

    @RequestMapping(value="", method = RequestMethod.GET)
   // @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<ExaminationPh> loadAllExaminations() {
        return this.examinationPhRepository.findAll();
    }

    @RequestMapping(value="/forPatient/{id}", method = RequestMethod.GET)
   // @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<ExaminationPh> findExamByPatientId(@PathVariable("id") Long id) {
        List<ExaminationPh> examinations = examinationPhService.findByPatientId(id);
        return examinations;
    }
}
