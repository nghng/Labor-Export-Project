package com.example.exportlabor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long agencyId;

    @NotBlank(message = "Agency must have a name")
    private String name;
    @NotBlank(message = "Agency must have a country name")
    private String destinationCountry;
    @Email
    private String email;
    @NotBlank(message = "Agency must have a number")
    @Size(min = 11)
    private String contactNumber;


    public Agency(Long agencyId, String name, String destinationCountry, String email, String contactNumber) {
        this.agencyId = agencyId;
        this.name = name;
        this.destinationCountry = destinationCountry;
        this.email = email;
        this.contactNumber = contactNumber;
    }



    public Agency() {
    }

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
