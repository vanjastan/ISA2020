package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Examination;

import java.util.List;

public interface ExaminationService {
    List<Examination> findAll();
    Examination findById(Long id);
    List<Examination> getByPatientId(Long id);
}
