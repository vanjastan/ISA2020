package com.example.Pharmacy.service;

import com.example.Pharmacy.dto.MedsReservationDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.User;

import javax.mail.MessagingException;

public interface EmailService {

    void sendMessageWithAttachment(String to, String pathToAttachment, Examination e) throws MessagingException;
    void sendMessageForReservedMed(String to, String pathToAttachment, MedsReservationDTO m) throws MessagingException;
    void approveRegistrationMail(User patient);
    void denyRegistrationMail(User patient);
}
