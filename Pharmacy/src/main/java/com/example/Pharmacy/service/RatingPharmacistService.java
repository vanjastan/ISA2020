package com.example.Pharmacy.service;

import com.example.Pharmacy.model.RatingPharmacist;

import java.util.List;

public interface RatingPharmacistService {
    List<RatingPharmacist> findAll();
    List<RatingPharmacist> findRateByDermatologist(Long id);
    RatingPharmacist saveRate(RatingPharmacist rate);
    List<RatingPharmacist> findRateByPatient(Long id);
}
