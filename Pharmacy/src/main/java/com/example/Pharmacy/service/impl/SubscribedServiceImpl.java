package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.SubscribedDTO;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.Subscribed;
import com.example.Pharmacy.repository.SubscribedRepository;
import com.example.Pharmacy.service.SubscribedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribedServiceImpl implements SubscribedService {

    @Autowired
    private SubscribedRepository subscribedRepository;

    @Autowired
    private EmailServiceImpl emailService;


    public List<Subscribed> findAll() throws AccessDeniedException {
        List<Subscribed> result = subscribedRepository.findAll();
        return result;
    }

    @Override
    public Subscribed findOne(Long id) {
        return subscribedRepository.findById(id).orElseGet(null);
    }

    @Override
    public Subscribed findByPatientId(Long patientId) {
        Subscribed result = subscribedRepository.findByPatientId(patientId);
        return result;
    }

    public Subscribed addEmails(SubscribedDTO dto){
        Subscribed s = new Subscribed();

        s.setEmail(dto.getEmail());
        s = this.subscribedRepository.save(s);
        return s;
    }
}
