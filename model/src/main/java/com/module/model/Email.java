package com.module.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Email {

    @Id @GeneratedValue
    @Column(name="email_id")
    private long emailId;
    private String subject;
    private String text;

    @ManyToMany(cascade = { CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_Email",
            joinColumns = { @JoinColumn(name = "emailId") },
            inverseJoinColumns = { @JoinColumn(name = "userId") }
    )
    private List<User> users=new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CoronaVirus coronaVirus;


    public Email(String subject, CoronaVirus coronaVirus) {
        this.subject = subject;
        this.coronaVirus = coronaVirus;
    }

    public Email(String subject) {
        this.subject = subject;
    }

    public CoronaVirus getCoronaVirus() {
        return coronaVirus;
    }


    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setCoronaVirus(CoronaVirus coronaVirus) {
        this.coronaVirus = coronaVirus;
    }

    public void setUsers(User user) {

        users.add(user);
    }

    @Override
    public String toString() {
        return "Email{" +
                "coronaVirus=" + coronaVirus +
                '}';
    }
}
