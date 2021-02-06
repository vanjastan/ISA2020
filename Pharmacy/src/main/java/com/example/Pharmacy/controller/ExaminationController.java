package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ExaminationDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.ExaminationRepository;
import com.example.Pharmacy.service.ExaminationService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.ExaminationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "/allExaminations")
    public ResponseEntity<List<ExaminationDTO>> getAllExaminations() {

        List<Examination> examinations = examinationService.findAll();

        List<ExaminationDTO> examinationDTO = new ArrayList<>();
        for (Examination e : examinations) {
            examinationDTO.add(new ExaminationDTO(e));
        }

        return new ResponseEntity<>(examinationDTO, HttpStatus.OK);
    }

    @RequestMapping(value="{patientId}/schedule/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Examination> scheduleExamination(@PathVariable("patientId") Long patientId, @PathVariable("id") Long id) throws MessagingException{

        User user = userService.findById(patientId);
        Examination patientExamination = examinationService.findById(id);
        patientExamination.setPatient(user);
        patientExamination = examinationService.save(patientExamination);

        try {
            serviceImpl.sendMessageWithAttachment("patientU45@gmail.com", "", patientExamination);
        } catch (Exception e){
            System.out.print("Message service does not work!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/freeExaminations")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<ExaminationDTO>> getFreeExaminations() {

        List<Examination> examinations = examinationService.findAll();

        List<ExaminationDTO> freeExaminations = new ArrayList<>();
        for (Examination e : examinations) {
            if(e.getPatient() == null) {
                freeExaminations.add(new ExaminationDTO(e));
            }
        }

        return new ResponseEntity<>(freeExaminations, HttpStatus.OK);
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
    @RequestMapping(value="/cancel/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Examination> cancelExamination(@PathVariable("id") Long id){
        Examination patientExamination = examinationService.findById(id);
        patientExamination.setPatient(null);
        patientExamination = examinationService.save(patientExamination);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
