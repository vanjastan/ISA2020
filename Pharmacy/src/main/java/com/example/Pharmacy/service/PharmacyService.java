package com.example.Pharmacy.service;
import com.example.Pharmacy.model.Pharmacies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PharmacyService {
    List<Pharmacies> findAll();
    Pharmacies findById(int admin_id);
}
