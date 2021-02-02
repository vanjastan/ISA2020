package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.ExaminationPh;
import com.example.Pharmacy.repository.ExaminationPhRepository;
import com.example.Pharmacy.service.ExaminationPhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationPhServiceImpl implements ExaminationPhService {

    @Autowired
    private ExaminationPhRepository examinationPhRepository;

    @Override
    public List<ExaminationPh> findAll() throws AccessDeniedException {
        List<ExaminationPh> result = examinationPhRepository.findAll();
        return result;
    }

    @Override
    public ExaminationPh findById(Long id) throws AccessDeniedException{
        ExaminationPh ePh = examinationPhRepository.findById(id).orElseGet(null);
        return ePh;
    }

    @Override
    public List<ExaminationPh> findByPatientId(Long id) {
        List<ExaminationPh> result = examinationPhRepository.findByPatientId(id);
        return result;
    }
}
