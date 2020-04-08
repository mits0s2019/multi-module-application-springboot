package com.module.service;



import com.module.model.Email;
import com.module.model.CoronaVirus;
import com.module.repository.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("emailService")
public class EmailServiceImpl implements  EmailService {

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    EmailRepo emailRepo;


    @Override
    public void save(Email email) {
        emailRepo.save(email);
    }

    public boolean sendMessageAsHtml(String recepient,String subject, CoronaVirus coronaVirus) {

        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setSubject(subject);
            helper.setTo(recepient);

            helper.setText("<html>" +
                    "<body>\n" +
                    "    \n" +
                    "    <h2>Latest updates : Coronavirus  </h2>\n" +
                    "    \n" +
                    "    <ul>\n" +
                    "        <li>Confirmed : " + coronaVirus.getConfirmed() + " </li>\n" +
                    "        <li>Recovered : " + coronaVirus.getRecovered() + "</li>\n" +
                    "        <li>Critical  : " + coronaVirus.getCritical() + "</li>\n" +
                    "        <li>Deaths    : " + coronaVirus.getDeaths() + "</li>\n" +
                    "    </ul>\n" +
                    "</body>" +
                    "</html>", true);

            emailSender.send(message);
            return true;
        }
        catch ( MessagingException e){
            e.printStackTrace();
        }
        return false;
    }
}
