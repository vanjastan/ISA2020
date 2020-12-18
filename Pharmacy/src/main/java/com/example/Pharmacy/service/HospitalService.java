package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> findAll();
    Hospital findById(Long id);
    Hospital findByName(String name);
}
