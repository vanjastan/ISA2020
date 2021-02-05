package com.example.Pharmacy.service;

import com.example.Pharmacy.dto.ComplaintsRequest;
import com.example.Pharmacy.model.Complaints;

import java.util.List;

public interface ComplaintsService {
    List<Complaints> findAll();
    boolean answer(ComplaintsRequest request);
}
