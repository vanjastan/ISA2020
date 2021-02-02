package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.EPrescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EPrescriptionRepository extends JpaRepository<EPrescription, Long> {
    List<EPrescription> findByPatientId(Long id);
}
