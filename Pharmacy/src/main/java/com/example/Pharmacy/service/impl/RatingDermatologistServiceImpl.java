package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.RatingDermatologist;
import com.example.Pharmacy.repository.RatingDermatologistRepository;
import com.example.Pharmacy.service.RatingDermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingDermatologistServiceImpl implements RatingDermatologistService {

    @Autowired
    RatingDermatologistRepository ratingDermatologistRepository;

    @Override
    public List<RatingDermatologist> findAll() {
        List<RatingDermatologist> all = ratingDermatologistRepository.findAll();
        return all;
    }

    public List<RatingDermatologist> findRateByDermatologist(Long id){
        return ratingDermatologistRepository.findByDermatologistId(id);
    }

    public RatingDermatologist saveRate(RatingDermatologist rate) {
        return ratingDermatologistRepository.save(rate);
    }

    public List<RatingDermatologist> findRateByPatient(Long id){
        return ratingDermatologistRepository.findByPatientId(id);
    }
}
