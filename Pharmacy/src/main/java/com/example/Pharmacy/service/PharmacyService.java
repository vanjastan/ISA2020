package com.example.Pharmacy.service;
import com.example.Pharmacy.model.Pharmacies;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PharmacyService {
    List<Pharmacies> findAll();
    Pharmacies findById(Long id);

    Pharmacies findOne(Long pharmacyId);

    Pharmacies findOnee(Long pharmacyId);

    Pharmacies findOneee(Long pharmacyId);
}
