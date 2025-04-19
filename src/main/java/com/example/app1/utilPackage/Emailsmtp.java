package com.example.app1.utilPackage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Emailsmtp {
    @Autowired
    private JavaMailSender smtp;
    @Value("${spring.mail.username}")
     private String fromAddress;
     public void sendMail(String ToAddress) {
             MimeMessage mme = smtp.createMimeMessage();
             MimeMessageHelper mmh = new MimeMessageHelper(mme);
     try {
        mmh.setTo(ToAddress);
        String subject = "Welcome!! NOW YOU ARE OUR NEW USER";
        String Body = "Thank you For Joining with us!!!";
        mmh.setSubject(subject);
        mmh.setText(Body);
        smtp.send(mme);
        }
     catch(MessagingException e) {
    	   throw new RuntimeException("Failed to send email",e);
     }
     }
}