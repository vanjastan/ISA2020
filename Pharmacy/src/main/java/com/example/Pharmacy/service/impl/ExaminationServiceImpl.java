package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.ExaminationRepository;
import com.example.Pharmacy.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Override
    public List<Examination> findAll() throws AccessDeniedException {
        List<Examination> result = examinationRepository.findAll();
        return result;
    }

    @Override
    public Examination findById(Long id) throws AccessDeniedException {
        Examination e = examinationRepository.findById(id).orElseGet(null);
        return e;
    }

    @Override
    public List<Examination> findByPatientId(Long id) {
        List<Examination> result = examinationRepository.findByPatientId(id);
        return result;
    }

    /*@Override
    public List<Examination> getByPatientId(Long id) {
        return examinationRepository.findByPatientId(id);
    }*/
}
