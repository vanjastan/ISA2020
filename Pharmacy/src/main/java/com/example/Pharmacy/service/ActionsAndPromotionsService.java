package com.example.Pharmacy.service;

import com.example.Pharmacy.model.ActionsAndPromotions;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ActionsAndPromotionsService {
    List<ActionsAndPromotions> findAll();
}
