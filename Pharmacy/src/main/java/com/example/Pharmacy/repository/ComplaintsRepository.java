package com.example.Pharmacy.repository;

import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.model.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintsRepository extends JpaRepository<Complaints, Long> {

    Complaints findOneById(Long complaintId);
}
