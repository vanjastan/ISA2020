package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.ActionsAndPromotions;
import com.example.Pharmacy.repository.ActionsAndPromotionsRepository;
import com.example.Pharmacy.service.ActionsAndPromotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionsAndPromotionsServiceImpl implements ActionsAndPromotionsService {

    @Autowired
    private ActionsAndPromotionsRepository actionsAndPromotionsRepository;

    public List<ActionsAndPromotions> findAll() throws AccessDeniedException{
        List<ActionsAndPromotions> result = actionsAndPromotionsRepository.findAll();
        return result;
    }
}
