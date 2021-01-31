package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination,Long> {
    List<Examination> findByPatientId(Long id);
}
