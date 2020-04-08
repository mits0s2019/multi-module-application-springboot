package com.module.service;

import com.module.model.Email;
import com.module.model.CoronaVirus;


public interface EmailService {

    boolean sendMessageAsHtml(String recepient,String subject, CoronaVirus coronaVirus);
    void save(Email email);
}
