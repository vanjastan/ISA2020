package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.EPrescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EPrescriptionRepository extends JpaRepository<EPrescription, Long> {
}
