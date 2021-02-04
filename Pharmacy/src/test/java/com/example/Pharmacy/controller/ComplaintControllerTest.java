package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ComplaintDTO;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.service.impl.ComplaintServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplaintControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("UTF-8"));

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    ComplaintServiceImpl complaintServiceImpl;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testAddComplaint() throws Exception {
        ComplaintDTO complaint = new ComplaintDTO();
        User patient = new User();
        patient.setId(3L);
        complaint.setDate_of_complaint("11.08.2020.");
        complaint.setContent("Doctor was rude.");
        complaint.setPatient(patient);

       complaintServiceImpl.addComplaint(complaint);
    }
}