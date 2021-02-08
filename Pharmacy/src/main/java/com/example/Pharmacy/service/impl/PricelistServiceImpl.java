package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.Pricelist;
import com.example.Pharmacy.repository.PricelistRepository;
import com.example.Pharmacy.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    public List<Pricelist> getPricelist() {
        List<Pricelist> p= pricelistRepository.findAll();
        return p;
    }

    public List<Pricelist> findAll() throws AccessDeniedException{
        List<Pricelist> result = pricelistRepository.findAll();
        return result;
    }


    public Pricelist findById(Long id) throws  AccessDeniedException{
        Pricelist p = pricelistRepository.findById(id).orElseGet(null);
        return p;
    }

    @Override
    public Pricelist save(Pricelist p) {
        return pricelistRepository.save(p);
    }

    public Pricelist findOne(Long id){
        return pricelistRepository.findById(id).orElseGet(null);
    }


}
