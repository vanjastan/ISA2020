package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.ComplaintDTO;
import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.ComplaintRepository;
import com.example.Pharmacy.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    public List<Complaint> findAll() throws AccessDeniedException {
        List<Complaint> result = complaintRepository.findAll();
        return result;
    }

    public List<Complaint> findByPatientId(Long id) {
        List<Complaint> result = complaintRepository.findByPatientId(id);
        return result;
    }

    @Override
    public Complaint findById(Long id) throws AccessDeniedException {
        Complaint complaint = complaintRepository.findById(id).orElseGet(null);
        return complaint;
    }

    @Override
    public Complaint save(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public Complaint addComplaint(ComplaintDTO dto) {

        Complaint complaint = new Complaint();

        complaint.setDate_of_complaint(dto.getDate_of_complaint());
        complaint.setContent(dto.getContent());
        complaint.setPatient(dto.getPatient());

        complaint = this.complaintRepository.save(complaint);
        return complaint;
    }
}
