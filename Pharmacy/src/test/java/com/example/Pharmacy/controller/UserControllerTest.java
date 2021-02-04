package com.example.Pharmacy.controller;

import com.example.Pharmacy.model.User;
import com.example.Pharmacy.service.UserService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;

public class UserControllerTest extends ApplicationTests {

    private static final String URL_PREFIX = "/api/users";

    private MockMvc mvc;

    @MockBean
    private UserService userService;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Test
    @Transactional
    @Rollback(true)
    public void testEditPatient() throws Exception {
        User patient = new User();
        patient.setName("Maja");
		patient.setSurname("Markovic");
		patient.setUsername("maki");
        patient.setCity("Beograd");
        patient.setCountry("Srbija");
        patient.setAddress("Markovica Marka 10");
        patient.setNumber("065224566");

        userService.save(patient);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testEditPatientsPassword() throws Exception {
        User patient = new User();
        patient.setPassword("$2y$12$I6Wg2298xZ.RW3mNLksrJe4Me3gv.MBl9.BM4tf.jx4JjqS43gKTe");

        userService.save(patient);
    }
}
