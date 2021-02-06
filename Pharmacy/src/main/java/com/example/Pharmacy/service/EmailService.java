package com.example.Pharmacy.service;

import com.example.Pharmacy.dto.ExaminationDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Meds;

import javax.mail.MessagingException;

public interface EmailService {

    void sendMessageWithAttachment(String to, String pathToAttachment, Examination e) throws MessagingException;
    void sendMessageForReservedMed(String to, String pathToAttachment, Meds m) throws MessagingException;
}
