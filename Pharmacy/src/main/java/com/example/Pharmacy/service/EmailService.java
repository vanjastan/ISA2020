package com.example.Pharmacy.service;

import javax.mail.MessagingException;

public interface EmailService {

    void sendMessageWithAttachment(String to, String pathToAttachment) throws MessagingException;
}
