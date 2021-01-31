package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.ExaminationPh;
import com.example.Pharmacy.repository.ExaminationPhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/examinationsPh")
public class ExaminationPhController {

    @Autowired
    ExaminationPhRepository examinationPhRepository;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<ExaminationPh> loadAllExaminations() {
        return this.examinationPhRepository.findAll();
    }
}
