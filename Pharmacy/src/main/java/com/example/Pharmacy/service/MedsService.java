package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Meds;

import java.util.List;

public interface MedsService {
    List<Meds> findAll();
    Meds findByName(String name);
}
