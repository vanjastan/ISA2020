package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ExaminationDTO;
import com.example.Pharmacy.dto.ExaminationPhDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.ExaminationPh;
import com.example.Pharmacy.repository.ExaminationPhRepository;
import com.example.Pharmacy.service.ExaminationPhService;
import com.example.Pharmacy.service.impl.ExaminationPhServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    ExaminationPhServiceImpl phServiceImpl;

    @GetMapping(value = "/allConsultations")
    public ResponseEntity<List<ExaminationPhDTO>> getAllConsultations() {

        List<ExaminationPh> consultations = examinationPhService.findAll();

        List<ExaminationPhDTO> examinationPhDTO = new ArrayList<>();
        for (ExaminationPh e : consultations) {
            examinationPhDTO.add(new ExaminationPhDTO(e));
        }

        return new ResponseEntity<>(examinationPhDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/forPatient/{id}", method = RequestMethod.GET)
   // @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<ExaminationPh> findExamByPatientId(@PathVariable("id") Long id) {
        List<ExaminationPh> examinations = examinationPhService.findByPatientId(id);
        return examinations;
    }

    @RequestMapping(value="/scheduled/{patientId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
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
    @PreAuthorize("hasRole('ROLE_PATIENT')")
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

    @RequestMapping(value="/cancel/{id}", method = RequestMethod.POST)
   // @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<ExaminationPh> cancelExamination(@PathVariable("id") Long id){
        ExaminationPh patientExamination = examinationPhService.findById(id);
        patientExamination.setPatient(null);
        patientExamination = examinationPhService.save(patientExamination);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/freeConsultations")
   // @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<ExaminationPhDTO>> getFreeConsultations() {

        List<ExaminationPh> consultations = examinationPhService.findAll();

        List<ExaminationPhDTO> freeConsultations = new ArrayList<>();
        for (ExaminationPh e : consultations) {
            if(e.getPatient() == null) {
                freeConsultations.add(new ExaminationPhDTO(e));
            }
        }

        return new ResponseEntity<>(freeConsultations, HttpStatus.OK);
    }
}
