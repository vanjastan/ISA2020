package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
    Medicament findByName(String name);
}
