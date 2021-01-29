package com.example.Pharmacy.repository;
import com.example.Pharmacy.model.Pharmacies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacies,Long> {
}
