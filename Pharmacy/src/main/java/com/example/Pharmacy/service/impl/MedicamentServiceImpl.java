package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.controller.MedicamentController;
import com.example.Pharmacy.dto.MedicamentDTO;
import com.example.Pharmacy.model.Medicament;
import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.repository.MedicamentRepository;
import com.example.Pharmacy.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    @Autowired
    MedicamentRepository medicamentRepository;

    @Override
    public List<Medicament> findAll() throws AccessDeniedException {
        List<Medicament> result = medicamentRepository.findAll();
        return result;
    }

    @Override
    public Medicament findByName(String name) throws UsernameNotFoundException {
        Medicament med = medicamentRepository.findByName(name);
        return med;
    }

    public Medicament addMedicament(MedicamentDTO dto){
        Medicament m = new Medicament();

        m.setName(dto.getName());
        m.setQuantity(dto.getQuantity());

        m = this.medicamentRepository.save(m);
        return m;
    }




}
