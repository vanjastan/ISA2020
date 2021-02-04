package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.repository.ExaminationRepository;
import com.example.Pharmacy.service.ExaminationService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.ExaminationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/examinations")
public class ExaminationController {

    @Autowired
    ExaminationRepository examinationRepository;

    @Autowired
    EmailServiceImpl serviceImpl;

    @Autowired
    ExaminationServiceImpl examinationServiceImpl;

    @Autowired
    ExaminationService examinationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Examination> loadAllExaminations() {
        return this.examinationRepository.findAll();
    }

    @RequestMapping(value="/reserve", method = RequestMethod.POST)
    public void sendNotification(Examination e) throws MessagingException {
        serviceImpl.sendMessageWithAttachment("patientU45@gmail.com", "", e);
    }

    @RequestMapping(value="/forPatient/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<Examination> findExaminationByPatientId(@PathVariable("id") Long id) {
        List<Examination> examinations = examinationService.findByPatientId(id);
        return examinations;
    }

    @RequestMapping(value="/scheduled/{patientId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<Examination> findScheduledForPatient(@PathVariable("patientId") Long patientId) {
        List<Examination> patientExaminations = examinationService.findByPatientId(patientId);
        List<Examination> examinations = new ArrayList<>();
        for(Examination e: patientExaminations){
            if(e.getPatient() != null) {
                examinations.add(e);
            }
        }
        return examinations;
    }

    @RequestMapping(value="/notScheduled/{patientId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<Examination> findNotScheduledExaminations(@PathVariable("patientId") Long patientId) {
        List<Examination> patientExaminations = examinationService.findByPatientId(patientId);
        List<Examination> examinations = new ArrayList<>();
        for(Examination e: patientExaminations){
            if(e.getPatient() == null) {
                examinations.add(e);
            }
        }
        return examinations;
    }

    @CrossOrigin()
    @RequestMapping(value="/unsubscribe/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Examination> unsubscribeExamination(@PathVariable("id") Long id){
        Examination patientExamination = examinationService.findById(id);
        patientExamination.setPatient(null);
        patientExamination = examinationService.save(patientExamination);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
