package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.ComplaintsRequest;
import com.example.Pharmacy.model.Complaints;
import com.example.Pharmacy.repository.ComplaintsRepository;
import com.example.Pharmacy.service.ComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintsServiceImpl implements ComplaintsService {

    @Autowired
    ComplaintsRepository complaintsRepository;

    @Autowired
    EmailServiceImpl _emailService;

    @Override
    public List<Complaints> findAll() {
        List<Complaints> result = complaintsRepository.findAll();
        return result;
    }

    @Override
    public boolean answer(ComplaintsRequest request) {
        Complaints complaint = complaintsRepository.findOneById(request.getComplaintId());
        complaint.setAnswered(true);
        complaintsRepository.save(complaint);

        _emailService.answerOnComplaint(request);
        return true;
    }
}
