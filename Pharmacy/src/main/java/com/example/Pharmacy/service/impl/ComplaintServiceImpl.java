package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.repository.ComplaintRepository;
import com.example.Pharmacy.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
