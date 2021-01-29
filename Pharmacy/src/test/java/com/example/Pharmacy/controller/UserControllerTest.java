package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class UserControllerTest extends ApplicationTests {

    private MockMvc mvc;

    private UserService userService;

    @Test
    void editUser() throws Exception{

    }
}