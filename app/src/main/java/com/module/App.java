package com.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages ={"com.module.*","com.module"})
@EntityScan(basePackages = {"com.module.*"})
@EnableJpaRepositories(basePackages = {"com.module.*"})
public class App  implements CommandLineRunner{


    @Autowired
    EmailRemainder emailRemainder;


    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... args) throws Exception {


        new Thread(emailRemainder.newRunnable()).start();
    }
}
