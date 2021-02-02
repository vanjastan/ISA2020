package com.example.Pharmacy.service;

import com.example.Pharmacy.model.EPrescription;
import java.util.List;

public interface EPrescriptionService {
    List<EPrescription> findAll();
    List<EPrescription> findByPatientId(Long id);
}
