package com.example.exportlabor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
@PrimaryKeyJoinColumn(name = "workerId", referencedColumnName = "userId")
public class Worker extends User {

    private enum Gender {
        MALE,
        FEMALE;
    }

    private static final int MAX_GENDER_VALUE = 1;


    @Past(message = "Date of birth must be less than today")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @Enumerated(EnumType.ORDINAL)
    @NotBlank(message = "Gender can not be blank")
    @Size(max = MAX_GENDER_VALUE)
    private Gender gender;
    @NotBlank(message = "Skill can not be blank")
    private String skill;
    @NotBlank(message = "Education can not be blank")
    private String education;
    @NotBlank(message = "Work experience can not be blank")

    private String workExperience;
    @NotBlank(message = "Desire salary can not be blank")
    @Size(min = 0)
    private Double desiredSalary;



}
