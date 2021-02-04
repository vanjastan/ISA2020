package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Complaint;

import java.util.List;

public interface ComplaintService {
    List<Complaint> findAll();
    List<Complaint> findByPatientId(Long id);
    Complaint findById(Long id);
    Complaint save(Complaint complaint);
}
