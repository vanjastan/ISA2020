package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.EPrescription;
import com.example.Pharmacy.repository.EPrescriptionRepository;
import com.example.Pharmacy.service.impl.EPrescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/prescriptions")
public class EPrescriptionController {

    @Autowired
    EPrescriptionRepository ePrescriptionRepository;

    @Autowired
    EPrescriptionServiceImpl ePrescriptionServiceImpl;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<EPrescription> loadAllPrescriptions() {
        return this.ePrescriptionRepository.findAll();
    }
}
