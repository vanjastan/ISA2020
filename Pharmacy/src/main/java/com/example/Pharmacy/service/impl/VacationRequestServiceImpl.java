package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.VacationRequest;
import com.example.Pharmacy.repository.VacationRequestRepository;
import com.example.Pharmacy.service.EmailService;
import com.example.Pharmacy.service.VacatioonRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VacationRequestServiceImpl implements VacatioonRequestService {

    @Autowired
    private VacationRequestRepository vacationRequestRepository;

    @Autowired
    private EmailService emailService;


    public VacationRequest findById(Long id) throws  AccessDeniedException {
        VacationRequest result = vacationRequestRepository.findById(id).orElseGet(null);
        return result;
    }
    public List<VacationRequest> findAll() throws AccessDeniedException {
        List<VacationRequest> result = vacationRequestRepository.findAll();
        return result;
    }

    @Override
    public VacationRequest save(VacationRequest vacationRequest){
        return vacationRequestRepository.save(vacationRequest);
    }
}
