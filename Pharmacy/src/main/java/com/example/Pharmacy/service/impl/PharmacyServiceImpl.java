package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.Medicament;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.repository.PharmacyRepository;
import com.example.Pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Override
    public List<Pharmacies> findAll() throws AccessDeniedException {
        List<Pharmacies> ph = pharmacyRepository.findAll();
        return ph;
    }
}
