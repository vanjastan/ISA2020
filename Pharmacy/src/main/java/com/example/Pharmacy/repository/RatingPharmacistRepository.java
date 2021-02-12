package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.RatingPharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RatingPharmacistRepository extends JpaRepository<RatingPharmacist, Long> {
    List<RatingPharmacist> findByPharmacistId(Long id);
    List<RatingPharmacist> findByPatientId(Long id);
}
