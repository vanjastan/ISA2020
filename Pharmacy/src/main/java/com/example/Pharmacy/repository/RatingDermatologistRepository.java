package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.RatingDermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface RatingDermatologistRepository extends JpaRepository<RatingDermatologist, Long> {
    List<RatingDermatologist> findByDermatologistId(Long id);
    List<RatingDermatologist> findByPatientId(Long id);
}
