package com.example.Pharmacy.repository;
import com.example.Pharmacy.model.Pharmacies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface PharmacyRepository extends JpaRepository<Pharmacies,Long> {

}
