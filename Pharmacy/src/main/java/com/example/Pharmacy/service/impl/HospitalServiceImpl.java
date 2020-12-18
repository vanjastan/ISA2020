package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.HospitalDTO;
import com.example.Pharmacy.exception.ApiRequestException;
import com.example.Pharmacy.model.Hospital;
import com.example.Pharmacy.repository.HospitalRepository;
import com.example.Pharmacy.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;

    public List<Hospital> findAll() throws AccessDeniedException {
        List<Hospital> result = hospitalRepository.findAll();
        return result;
    }

    public Hospital findById(Long id) throws AccessDeniedException{
        Hospital hos = hospitalRepository.findById(id).orElseGet(null);
        return hos;
    }

    public Hospital findByName(String name) throws UsernameNotFoundException {
        Hospital h = hospitalRepository.findByName(name);
        return h;
    }


    public Hospital addHospital(HospitalDTO hdto) {
        Hospital hos = new Hospital();

        if (hospitalRepository.findByName(hdto.getName()) != null) {
            throw new ApiRequestException("Name '" + hdto.getName() + "' already exists.");
        }

        hos.setName(hdto.getName());
        hos.setApi(hdto.getApi());

        hos = this.hospitalRepository.save(hos);
        return hos;
    }
}
