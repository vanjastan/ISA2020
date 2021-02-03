package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.ExaminationPh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExaminationPhRepository extends JpaRepository<ExaminationPh, Long>{
    List<ExaminationPh> findByPatientId(Long id);
}
