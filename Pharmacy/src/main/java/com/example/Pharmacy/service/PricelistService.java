package com.example.Pharmacy.service;

import com.example.Pharmacy.dto.PricelistDTO;
import com.example.Pharmacy.model.Pricelist;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PricelistService {
    List<Pricelist> findAll();

    Pricelist findById(Long id);

    Pricelist save(Pricelist pricelistInfo);

    Pricelist findOne(Long id);

}
