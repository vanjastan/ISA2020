package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.repository.PharmacyRepository;
import com.example.Pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Override
    public List<Pharmacies> findAll() throws AccessDeniedException {
        List<Pharmacies> ph = pharmacyRepository.findAll();
        return ph;
    }

    public Pharmacies findById(Long id) throws AccessDeniedException {
        Pharmacies ph = pharmacyRepository.findById(id).orElseGet(null);
        return ph;
    }

    /*public List<Pharmacies> findByDermatologistId(Long id) {
        List<Pharmacies> result = pharmacyRepository.findByDermId(id);
        return result;
    }*/

    public Pharmacies findOne(Long id) {
        return pharmacyRepository.findById(id).orElseGet(null);
    }

    public Pharmacies findOnee(Long id) {
        return pharmacyRepository.findById(id).orElseGet(null);
    }


    public Pharmacies findOneee(Long pharmacyId) {
        return pharmacyRepository.findById(pharmacyId).orElseGet(null);
    }

}