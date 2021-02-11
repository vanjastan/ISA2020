package com.example.Pharmacy.repository;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.MedsReservation;
import com.example.Pharmacy.model.Pharmacies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MedsReservationRepository extends JpaRepository<MedsReservation,Long> {
    Pharmacies findByReservationId(Long reservationId);
    Meds findByMedicine(Long medicine);
}
