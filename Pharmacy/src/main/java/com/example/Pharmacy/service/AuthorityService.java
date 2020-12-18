package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Authority;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface AuthorityService {
	List<Authority> findById(Long id);
	List<Authority> findByname(String name);
}
