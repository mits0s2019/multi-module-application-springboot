package com.module;

import com.module.model.Email;
import com.module.service.EmailService;
import com.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;


@SpringBootApplication
@ComponentScan(basePackages ={"com.module.*","com.module"})
@EntityScan(basePackages = {"com.module.*"})
@EnableJpaRepositories(basePackages = {"com.module.*"})
public class App  implements CommandLineRunner{

    @Autowired
    UserService userService;

    @Autowired
    @Qualifier("emailService")
    EmailService emailService;

    @Autowired
    EmailRemainder emailRemainder;


    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("main app");

    }
}
