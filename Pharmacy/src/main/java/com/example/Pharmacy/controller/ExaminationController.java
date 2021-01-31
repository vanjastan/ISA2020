package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.ExaminationRepository;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.ExaminationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    ExaminationServiceImpl examinationService;

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
//OVDE PADA PROVERI ZASTO!!!!!!!!!!!!!!!
   /* @RequestMapping(value="/scheduled", method = RequestMethod.GET)
    public List<Examination> scheduledExaminations(User u) {
        User user = userService.findById(u.getId());
        List<Examination> setEx = examinationService.getByPatientId(user.getId());
        return setEx;
    }*/

}
