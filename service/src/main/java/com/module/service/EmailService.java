package com.module.service;

import com.module.model.Email;


public interface EmailService {

    void sendSimpleMessage(Email email);

    void sendMessageWithAttachment(Email email);
}
