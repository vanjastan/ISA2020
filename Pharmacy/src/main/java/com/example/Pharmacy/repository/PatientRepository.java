package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findOneById(Long id);
}
