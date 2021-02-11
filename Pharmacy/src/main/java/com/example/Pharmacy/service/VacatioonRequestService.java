package com.example.Pharmacy.service;

import com.example.Pharmacy.model.VacationRequest;

import java.util.List;

public interface VacatioonRequestService {
    List<VacationRequest> findAll();

    VacationRequest save(VacationRequest vacationRequest);

    VacationRequest findById(Long id);
}
