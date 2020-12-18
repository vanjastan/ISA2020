package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    Hospital findByName(String name);
}
