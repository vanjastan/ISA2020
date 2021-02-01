package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    ComplaintRepository complaintRepository;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Complaint> loadAllComplaints() {
        return this.complaintRepository.findAll();
    }
}
