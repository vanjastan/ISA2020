package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByName(String name);
}