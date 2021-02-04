package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ComplaintDTO;
import com.example.Pharmacy.dto.HospitalDTO;
import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.model.EPrescription;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.ComplaintRepository;
import com.example.Pharmacy.service.ComplaintService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.ComplaintServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    ComplaintServiceImpl complaintServiceImpl;

    @Autowired
    ComplaintService complaintService;

    @Autowired
    UserService userService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Complaint> loadAllComplaints() {
        return this.complaintRepository.findAll();
    }

    @PostMapping("/addComplaint")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity addComplaint(@RequestBody ComplaintDTO dto) {
        complaintServiceImpl.addComplaint(dto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/forPatient/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public List<Complaint> findComplaintsByPatientId(@PathVariable("id") Long id) {
        List<Complaint> complaints = complaintService.findByPatientId(id);
        return complaints;
    }
}
