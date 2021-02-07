package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.ExaminationDTO;
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

    public Examination findById(Long id) throws AccessDeniedException {
        Examination e = examinationRepository.findById(id).orElseGet(null);
        return e;
    }

    @Override
    public List<Examination> findByPatientId(Long id) {
        List<Examination> result = examinationRepository.findByPatientId(id);
        return result;
    }

    @Override
    public Examination save(Examination e) {
        return examinationRepository.save(e);
    }

    @Override
    public Examination findOne(Long id) {
        return null;
    }

    /*public Examination addExamination(ExaminationDTO eDTO){
        Examination examination = new Examination();
        examination.setPatient(eDTO.getPatient());
        examination = this.examinationRepository.save(examination);

        return examination;
    }*/

}
