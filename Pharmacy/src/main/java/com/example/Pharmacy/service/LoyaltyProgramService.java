package com.example.Pharmacy.service;

import com.example.Pharmacy.model.LoyaltyProgram;
import java.util.List;

public interface LoyaltyProgramService {
    List<LoyaltyProgram> findAll();
    LoyaltyProgram save(LoyaltyProgram loyaltyProgram);
}
