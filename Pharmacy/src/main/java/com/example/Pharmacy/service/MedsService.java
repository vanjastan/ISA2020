package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Meds;

import java.util.List;

public interface MedsService {
    List<Meds> findAll();
    List<Meds> findByPatientId(Long id);
    Meds findByName(String name);
    Meds findById(Long id);
    Meds save(Meds m);
    List<Meds> findByPrescriptionId(Long id);
}
