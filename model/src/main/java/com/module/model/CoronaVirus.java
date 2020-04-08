package com.module.model;

import com.module.model.Email;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CoronaVirus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coronaId;
    private String confirmed;
    private String recovered;
    private String critical;
    private String deaths;
    @CreationTimestamp
    private LocalDateTime DateTime;

    @OneToMany(mappedBy = "coronaVirus",cascade = CascadeType.PERSIST)
    private List<Email> emails=new ArrayList<>();

    public CoronaVirus() {}


    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getCritical() {
        return critical;
    }

    public String getDeaths() {
        return deaths;
    }

    public LocalDateTime getDateTime() {
        return DateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        DateTime = dateTime;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return
                "confirmed='" + confirmed + '\'' +
                ", recovered='" + recovered + '\'' +
                ", critical='" + critical + '\'' +
                ", deaths='" + deaths + '\'';
    }
}
