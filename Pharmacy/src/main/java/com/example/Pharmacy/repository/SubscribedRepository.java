package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Subscribed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface SubscribedRepository extends JpaRepository<Subscribed, Long> {
    Subscribed findByPatientId(Long patientId);
}
