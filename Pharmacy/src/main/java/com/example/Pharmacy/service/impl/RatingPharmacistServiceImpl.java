package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.RatingPharmacist;
import com.example.Pharmacy.repository.RatingPharmacistRepository;
import com.example.Pharmacy.service.RatingPharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingPharmacistServiceImpl implements RatingPharmacistService {

    @Autowired
    private RatingPharmacistRepository ratingPharmacistRepository;

    @Override
    public List<RatingPharmacist> findAll() {
        List<RatingPharmacist> all = ratingPharmacistRepository.findAll();
        return all;
    }

    @Override
    public List<RatingPharmacist> findRateByDermatologist(Long id) {
        return ratingPharmacistRepository.findByPharmacistId(id);
    }

    @Override
    public RatingPharmacist saveRate(RatingPharmacist rate) {
        return ratingPharmacistRepository.save(rate);
    }

    @Override
    public List<RatingPharmacist> findRateByPatient(Long id) {
        return ratingPharmacistRepository.findByPatientId(id);
    }
}
