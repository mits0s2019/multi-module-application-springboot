package com.module;

import com.google.gson.Gson;
import com.module.model.CoronaVirus;
import com.module.model.Email;
import com.module.model.User;
import com.module.service.EmailService;
import com.module.service.UserService;
import com.module.webService.api.CoronaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class EmailRemainder {

    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;
    @Autowired
    CoronaApi coronaApi;

    @Bean
    @Scope("prototype")
    public Runnable newRunnable() {

        return new Runnable() {
            public void run() {

                while (true) {

                    try {
                        Email email=new Email("Corona virus Update");

                        CoronaVirus[]  coronaVirusArray = new Gson().fromJson(coronaApi.getResults(), CoronaVirus[].class);

                        email.setCoronaVirus(coronaVirusArray[0]);

                        List<User> users = userService.fetchUsers();

                        users.stream().forEach(user -> {

                            email.setUsers(user);

                            boolean sent = emailService.sendMessageAsHtml(user.getEmailAdress(),
                                                                          email.getSubject(),
                                                                          email.getCoronaVirus());
                            if (sent) {

                                emailService.save(email);

                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

}
