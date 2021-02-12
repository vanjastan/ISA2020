package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.LoyaltyProgram;
import com.example.Pharmacy.repository.LoyaltyProgramRepository;
import com.example.Pharmacy.service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoyaltyProgramServiceImpl implements LoyaltyProgramService {

    @Autowired
    private LoyaltyProgramRepository loyaltyProgramRepository;

    @Override
    public List<LoyaltyProgram> findAll() throws AccessDeniedException {
        List<LoyaltyProgram> result = loyaltyProgramRepository.findAll();
        return result;
    }

    @Override
    public LoyaltyProgram save(LoyaltyProgram loyaltyProgram) {
        return loyaltyProgramRepository.save(loyaltyProgram);
    }
}
