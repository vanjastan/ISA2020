package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Subscribed;

import java.util.List;

public interface SubscribedService {
    List<Subscribed> findAll();
    Subscribed findOne(Long id);
    Subscribed findByPatientId(Long patientId);
}
