package com.module.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@ToString
@Entity
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private long userId;
    private String firstName;
    private String lastName;
    @Column(name="email_adress")
    private String emailAdress;

    @ManyToMany(cascade = { CascadeType.PERSIST ,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(
            name = "User_Email",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "emailId") }
    )
    private List<Email> emails;

    public User (String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public User(String firstName, String lastName, String emailAdress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getEmailAdress() {
        return emailAdress;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
