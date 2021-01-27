package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination,Long> {
}
