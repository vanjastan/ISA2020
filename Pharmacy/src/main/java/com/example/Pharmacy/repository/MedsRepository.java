package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Meds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedsRepository extends JpaRepository<Meds,Long> {
    Meds findByName(String name);
    List<Meds> findByPatientId(Long id);
}
