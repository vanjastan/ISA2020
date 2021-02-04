package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
    Medicament findByName(String name);
}
