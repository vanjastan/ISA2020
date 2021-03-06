package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.MedsReservation;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.repository.MedsReservationRepository;
import com.example.Pharmacy.service.MedsReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedsReservationServiceImpl implements MedsReservationService {

    @Autowired
    private MedsReservationRepository reservationRepository;

    @Override
    public List<MedsReservation> findAll() throws AccessDeniedException {
        List<MedsReservation> result = reservationRepository.findAll();
        return result;
    }

    @Override
    public MedsReservation save(MedsReservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Pharmacies findByReservationId(Long id) {
        return reservationRepository.findByReservationId(id);
    }

    @Override
    public Meds findByMedicine(Long medicine) {
        return reservationRepository.findByMedicine(medicine);
    }
}
