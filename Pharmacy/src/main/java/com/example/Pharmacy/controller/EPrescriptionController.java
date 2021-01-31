package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.EPrescription;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.EPrescriptionRepository;
import com.example.Pharmacy.service.EPrescriptionService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EPrescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/prescriptions")
public class EPrescriptionController {

    @Autowired
    EPrescriptionRepository ePrescriptionRepository;

    @Autowired
    EPrescriptionServiceImpl ePrescriptionServiceImpl;

    @Autowired
    UserService userService;

    @Autowired
    EPrescriptionService ePrescriptionService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<EPrescription> loadAllPrescriptions() {
        return this.ePrescriptionRepository.findAll();
    }

    @RequestMapping(value="/forPatient/{id}", method = RequestMethod.GET)
    public List<EPrescription> findPrescriptionByPatientId(@PathVariable("id") Long id) {
        List<EPrescription> pres = ePrescriptionService.findByPatientId(id);
        return pres;
    }
}
