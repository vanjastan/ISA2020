package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
