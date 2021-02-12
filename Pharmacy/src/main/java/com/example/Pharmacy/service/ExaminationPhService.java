package com.example.Pharmacy.service;

import com.example.Pharmacy.model.ExaminationPh;

import java.util.List;

public interface ExaminationPhService {
    List<ExaminationPh> findAll();
    ExaminationPh findById(Long id);
    List<ExaminationPh> findByPatientId(Long id);
    ExaminationPh save(ExaminationPh e);
    ExaminationPh findByDateExamination(String dateOfConsultation);
}
