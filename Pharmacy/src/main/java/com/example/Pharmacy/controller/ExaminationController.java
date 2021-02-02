package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.ExaminationRepository;
import com.example.Pharmacy.service.ExaminationService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.ExaminationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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
    public List<Examination> findExaminationByPatientId(@PathVariable("id") Long id) {
        List<Examination> examinations = examinationService.findByPatientId(id);
        return examinations;
    }

}
