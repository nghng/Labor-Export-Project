package com.example.exportlabor.model;

import jakarta.persistence.*;

@Entity
public class Employer extends User {
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;
    @ManyToOne
    @JoinColumn(columnDefinition = "agencyId")
    private Agency agency;

    public Employer(Long userId, String username, String password, String email, String name, Long employerId, Agency agency) {
        super(userId, username, password, email, name);
        this.employerId = employerId;
        this.agency = agency;
    }

    public Employer(Long employerId, Agency agency) {
        this.employerId = employerId;
        this.agency = agency;
    }

    public Employer() {
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
