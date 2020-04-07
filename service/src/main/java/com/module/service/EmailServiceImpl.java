package com.module.service;


import com.module.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("emailService")
public class EmailServiceImpl implements  EmailService {

    @Autowired
    private JavaMailSender emailSender;


    public void sendSimpleMessage(Email email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }


    public void sendMessageWithAttachment(Email email) {
        try {
            MimeMessage message = emailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getText());

            FileSystemResource file = new FileSystemResource(new File(email.getPathToAttachment()));
            helper.addAttachment("Invoice", file);

            emailSender.send(message);

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}
