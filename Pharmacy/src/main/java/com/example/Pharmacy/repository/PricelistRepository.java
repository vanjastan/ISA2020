package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {
}
