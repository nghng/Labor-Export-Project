package com.example.exportlabor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long agencyId;

    @NotBlank(message = "Agency must have a name")
    private String name;
    @NotBlank(message = "Agency must have a country name")
    private String destinationCountry;
    @Email(message = "Invalid email address")
    @Column(unique = true)
    @NotBlank(message = "Email can't be blank")
    private String email;
    @NotBlank(message = "Agency must have a contact number")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
    private String contactNumber;




}
