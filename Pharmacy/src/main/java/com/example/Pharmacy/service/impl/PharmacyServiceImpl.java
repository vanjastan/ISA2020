package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.PharmacyRepository;
import com.example.Pharmacy.service.AuthorityService;
import com.example.Pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

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
