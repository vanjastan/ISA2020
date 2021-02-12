package com.example.Pharmacy.service;

import com.example.Pharmacy.model.RatingDermatologist;

import java.util.List;

public interface RatingDermatologistService {
    List<RatingDermatologist> findAll();
    List<RatingDermatologist> findRateByDermatologist(Long id);
    RatingDermatologist saveRate(RatingDermatologist rate);
    List<RatingDermatologist> findRateByPatient(Long id);
}
