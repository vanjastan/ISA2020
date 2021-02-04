package com.example.Pharmacy.repository;


import com.example.Pharmacy.model.Meds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MedsRepository extends JpaRepository<Meds,Long> {
    Meds findByName(String name);
}
