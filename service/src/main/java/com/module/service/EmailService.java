package com.module.service;



import com.module.model.Email;
import com.module.model.CoronaVirus;
import com.module.repository.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;


import org.springframework.stereotype.Service;



@Service("emailService")
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    EmailRepo emailRepo;


    public void save(Email email) {
        emailRepo.save(email);
    }

}
