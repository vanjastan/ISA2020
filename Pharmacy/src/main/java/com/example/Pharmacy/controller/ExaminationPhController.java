package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.ExaminationPh;
import com.example.Pharmacy.repository.ExaminationPhRepository;
import com.example.Pharmacy.service.ExaminationPhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @RequestMapping(value="/scheduled/{patientId}", method = RequestMethod.GET)
    public List<ExaminationPh> findScheduledForPatient(@PathVariable("patientId") Long patientId) {
        List<ExaminationPh> patientExaminations = examinationPhService.findByPatientId(patientId);
        List<ExaminationPh> examinations = new ArrayList<>();
        for(ExaminationPh e: patientExaminations){
            if(e.getPatient() != null) {
                examinations.add(e);
            }
        }
        return examinations;
    }

    @RequestMapping(value="/notScheduled/{patientId}", method = RequestMethod.GET)
    public List<ExaminationPh> findNotScheduledExaminations(@PathVariable("patientId") Long patientId) {
        List<ExaminationPh> patientExaminations = examinationPhService.findByPatientId(patientId);
        List<ExaminationPh> examinations = new ArrayList<>();
        for(ExaminationPh e: patientExaminations){
            if(e.getPatient() == null) {
                examinations.add(e);
            }
        }
        return examinations;
    }
}
