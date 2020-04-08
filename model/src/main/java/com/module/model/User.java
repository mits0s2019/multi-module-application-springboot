package com.module.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long userId;
    private String firstName;
    private String lastName;
    @Column(name="email_adress")
    private String emailAdress;

    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    private List<Email> emails=new ArrayList<>();



    public User (String emailAdress) {
        this.emailAdress = emailAdress;
    }



    public String getEmailAdress() {
        return emailAdress;
    }


    public void setEmails(Email email) {
        emails.add(email);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
}
