package com.example.notes.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.notes.domain.Email;
import com.example.notes.enums.EmailStatus;
import com.example.notes.repository.EmailRepository;

@Service
public class EmailService {
    
    @Autowired
    EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;

    public Email sendEmail(Email email){
        email.setSendDateEmail(LocalDateTime.now());
        email.setSubject("Confirme seu email");
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(EmailStatus.SENT);
        } catch (MailException e){
            email.setStatusEmail(EmailStatus.ERROR);
        } finally {
            return emailRepository.save(email);
        }
    }
}
