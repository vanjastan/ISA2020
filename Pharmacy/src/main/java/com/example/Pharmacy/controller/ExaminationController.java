package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/examinations")
public class ExaminationController {

    @Autowired
    ExaminationRepository examinationRepository;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Examination> loadAllExaminations() {
        return this.examinationRepository.findAll();
    }
}
