package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Examination;

import javax.mail.MessagingException;

public interface EmailService {

    void sendMessageWithAttachment(String to, String pathToAttachment, Examination e) throws MessagingException;
}
