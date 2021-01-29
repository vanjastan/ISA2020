package com.example.Pharmacy.controller;

import com.example.Pharmacy.service.impl.EmailServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExaminationControllerTest extends ApplicationTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private EmailServiceImpl emailService;

    private JavaMailSender mailSender;

    private MimeMessage mimeMessage;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void loadAllExaminations() throws Exception {

        mvc.perform(get("/examinations")).andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].price").value(2000.0))
                .andExpect(jsonPath("$[0].duration").value("1h"))
                .andExpect(jsonPath("$[0].dateOfEx").value("11.11.2020."))
                .andExpect(jsonPath("$[0].date").value("11.11.2020."));
    }

    @Test
    public void sendNotification() throws MessagingException, IOException {
       /* String to = "patientU45@gmail.com";
        String subject = "Reserved examination";
        String msg = "You have successfully reserved examination!";

        // when
        emailService.sendMessageWithAttachment(to, subject);

        // then
        assertEquals(to, mimeMessage.getAllRecipients()[0].toString());
        assertEquals(subject, mimeMessage.getSubject());
        assertEquals(msg, mimeMessage.getContent().toString());*/
    }
}