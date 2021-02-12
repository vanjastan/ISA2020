package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.*;
import com.example.Pharmacy.dto.ExaminationDTO;
import com.example.Pharmacy.dto.SubscribedDTO;
import com.example.Pharmacy.model.*;
import com.example.Pharmacy.config.EmailContext;
import com.example.Pharmacy.dto.SubscribedDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.repository.PatientRepository;
import com.example.Pharmacy.repository.UserRepository;
import com.example.Pharmacy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    private EmailServiceImpl emailService;

    private Subscribed subscribed;

    private final EmailContext _emailContext;
    private final UserRepository _patientRepository;

    public EmailServiceImpl(EmailContext emailContext, UserRepository patientRepository) {
        _emailContext = emailContext;
        _patientRepository = patientRepository;
    }

    public void answerOnComplaint(ComplaintsRequest request) {
        User user = _patientRepository.findOneById(request.getPatientId());
        String to = user.getEmail();
        String subject = "Answer on complaint";
        Context context = new Context();
        context.setVariable("name", String.format("%s %s", user.getName(), user.getSurname()));
        context.setVariable("text", String.format("%s",  request.getText()));
        _emailContext.send(to, subject, "answerOnComplaint", context);
    }

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

    public void sendMessageForReservedMed(String to, String pathToAttachment, MedsReservationDTO m) throws MessagingException {

        String text = "You have successfully reserved medicine!" +
                "For date: " + m.getDateReservation();
        
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("patientU45@gmail.com");
        helper.setSubject("Reserved medicine");
        helper.setText(text);

        emailSender.send(message);
    }

    public void sendMessageScheduledConsultation(String to, String pathToAttachment, ExaminationPh e) throws MessagingException{
        String text = "You have successfully reserved consultation with pharmacist!" + e.getPharmacist();

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("patientU45@gmail.com");
        helper.setSubject("Reserved consultation");
        helper.setText(text);

        emailSender.send(message);
    }

    @Async
    public void sendActionsNotifications (Subscribed s) throws MessagingException{
        String text = "Check out our new action / promotion at the link - http://localhost:4200/adminph/action";

        MimeMessage mess = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mess, true);

        helper.setTo(s.getEmail());
        helper.setSubject("New action/promotion");
        helper.setText(text);

        emailSender.send(mess);
    }


    @Async
    public void sendVacationConfirmation (VacationRequest r) throws MessagingException{
        String text = "Congratulations, your request for holiday has been approved. Enjoy your holiday.";

        MimeMessage mess = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mess, true);

        helper.setTo(r.getUser().getEmail());
        helper.setSubject("Vacation confirmation");
        helper.setText(text);

        emailSender.send(mess);
    }


    @Async
    public void sendVacationRefuse (VacationRequest r, String message) throws MessagingException{
        String text = "We are sorry, your request for holiday has been refused.";

        MimeMessage mess = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mess, true);

        helper.setTo(r.getUser().getEmail());
        helper.setSubject("Vacation request refused!");
        helper.setText(text + message);

        emailSender.send(mess);
    }


    @Override
    public void approveRegistrationMail(User patient) {
        String to = patient.getEmail();
        System.out.println(to);
        String subject = "Your registration has been approved.";
        Context context = new Context();
        context.setVariable("name", String.format("%s %s", patient.getName(), patient.getSurname()));
        context.setVariable("link", String.format("http://localhost:4200/frontpage/login/%s", patient.getId()));
        _emailContext.send(to, subject, "approvedRegistration", context);
    }

    @Override
    public void denyRegistrationMail(User patient) {
        String to = patient.getEmail();
        System.out.println(to);
        String subject = "Your registration has been denied.";
        Context context = new Context();
        context.setVariable("name", String.format("%s %s", patient.getName(), patient.getSurname()));
        _emailContext.send(to, subject, "deniedRegistration", context);
    }

    @Async
    public void sendForOrder (OrderFormOffers r) throws MessagingException{
        String text = "Congratulations, your are winner of order.";

        MimeMessage mess = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mess, true);

        helper.setTo(r.getSupplier().getEmail());
        helper.setSubject("Order confirmation");
        helper.setText(text);

        emailSender.send(mess);
    }

    @Async
    public void sendForOrders (OrderFormOffers r) throws MessagingException{
        String text = "We are announcing,  order is now closed.";

        MimeMessage mess = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mess, true);

        helper.setTo(r.getSupplier().getEmail());
        helper.setSubject("Order information");
        helper.setText(text);

        emailSender.send(mess);
    }

}
