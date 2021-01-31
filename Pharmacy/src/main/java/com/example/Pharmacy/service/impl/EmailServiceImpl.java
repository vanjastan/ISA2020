package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendMessageWithAttachment(String to, String pathToAttachment, Examination e) throws MessagingException {

        String text = "You have successfully reserved examination!" +
                "Your examination is scheduled for: " + e.getDate() + "," + e.getTime();
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("patientU45@gmail.com");
        helper.setSubject("Reserved examination");
        helper.setText(text);

        emailSender.send(message);
    }
}
