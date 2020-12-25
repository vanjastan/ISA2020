package com.example.Pharmacy.service;

import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.dto.UserRegistrationDTO;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.model.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
	User save(User userRequest);
    User addUser(UserRegistrationDTO userInfo);
    User addUserSup(UserRegistrationDTO userInfo);
    User addUserDerm(UserRegistrationDTO userInfo);
    User editUser(UserDTO user);
    void delete(Long id);
    void activateUser(Long id);
}
