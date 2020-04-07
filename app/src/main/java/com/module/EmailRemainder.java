package com.module;

import com.module.model.Email;
import com.module.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class EmailRemainder {

    private String timer;
    private Email email;


    @Bean
    @Scope("prototype")
    public Runnable newRunnable(EmailService emailService) {

        return new Runnable() {
            public void run() {

                while (true) {

                    Calendar a = Calendar.getInstance();

                    String sec = Integer.toString(a.get(Calendar.SECOND));
                    String min = Integer.toString(a.get(Calendar.MINUTE));
                    String hour = Integer.toString(a.get(Calendar.HOUR_OF_DAY));
                    String time = hour + ":" + min + ":" + sec;
                    System.out.println(time);
                    if (time.equals(timer)) {

                        emailService.sendSimpleMessage(email);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
