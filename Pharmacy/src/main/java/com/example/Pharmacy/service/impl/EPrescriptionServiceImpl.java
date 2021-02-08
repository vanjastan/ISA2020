package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.EPrescription;
import com.example.Pharmacy.repository.EPrescriptionRepository;
import com.example.Pharmacy.service.EPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EPrescriptionServiceImpl implements EPrescriptionService {

    @Autowired
    EPrescriptionRepository ePrescriptionRepo;

    public List<EPrescription> findAll() throws AccessDeniedException {
        List<EPrescription> result = ePrescriptionRepo.findAll();
        return result;
    }

    @Override
    public List<EPrescription> findByPatientId(Long id) {
        List<EPrescription> result = ePrescriptionRepo.findByPatientId(id);
        return result;
    }

    @Override
    public EPrescription findOne(Long id) {
        return ePrescriptionRepo.findById(id).orElseGet(null);
    }
}
