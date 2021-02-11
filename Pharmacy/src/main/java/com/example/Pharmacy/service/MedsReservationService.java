package com.example.Pharmacy.service;

import com.example.Pharmacy.dto.MedsReservationDTO;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.MedsReservation;
import com.example.Pharmacy.model.Pharmacies;

import java.util.List;

public interface MedsReservationService {
    List<MedsReservation> findAll();
    MedsReservation save(MedsReservation reservation);
    Pharmacies findByReservationId(Long reservationId);
    Meds findByMedicine(Long medicine);
}
