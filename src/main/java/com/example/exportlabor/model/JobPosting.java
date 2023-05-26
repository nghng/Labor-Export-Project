package com.example.exportlabor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobPostingId;
    @ManyToOne
    @JoinColumn(name = "agencyId")
    private Agency agency;
    @NotBlank(message = "A description is needed")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date uploadedDate;
    @DecimalMin(value = "0.01", message = "Salary cannot be less than 0.01")
    private Double salary;
    @Min(value = 1, message = "Quantity cannot be less than 1")
    private int quantity;
}
