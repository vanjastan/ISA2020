package com.example.Pharmacy.service.impl;

import com.example.Pharmacy.dto.ExaminationDTO;
import com.example.Pharmacy.dto.SubscribedDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.config.EmailContext;
import com.example.Pharmacy.dto.ComplaintsRequest;
import com.example.Pharmacy.dto.SubscribedDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Patient;
import com.example.Pharmacy.model.Subscribed;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.PatientRepository;
import com.example.Pharmacy.repository.UserRepository;
import com.example.Pharmacy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void sendMessageForReservedMed(String to, String pathToAttachment, Meds m) throws MessagingException {

        String text = "You have successfully reserved medicine!" +
                "Medicine name: " + m.getName();
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("patientU45@gmail.com");
        helper.setSubject("Reserved examination");
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
}
