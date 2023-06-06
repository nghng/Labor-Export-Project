package com.example.exportlabor.model;

import com.example.exportlabor.validation.AddWorkerValidationGroup;
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
@PrimaryKeyJoinColumn(name = "workerId", referencedColumnName = "userId")
public class Worker extends User {

    private enum Gender {
        MALE,
        FEMALE;
    }

    private enum Education {
        PRIMARY_SCHOOL,
        SECONDARY_SCHOOL,
        HIGH_SCHOOL,
        BACHELOR_DEGREE,
        MASTER_DEGREE,
        PHD_DEGREE,
        NONE
    }

    private static final int MAX_GENDER_VALUE = 1;


    @Past(message = "Date of birth must be less than today")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(groups = AddWorkerValidationGroup.class)
    private Date dob;
    @Enumerated(EnumType.ORDINAL)
    @NotNull(groups = AddWorkerValidationGroup.class)
    private Gender gender;
    @NotBlank(message = "Skill can not be blank",groups = AddWorkerValidationGroup.class)
    private String skill;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Education can not be null",groups = AddWorkerValidationGroup.class)
    private Education education;
    @NotBlank(message = "Work experience can not be blank",groups = AddWorkerValidationGroup.class)
    private String workExperience;
    @DecimalMin(value  = "0.1",groups = AddWorkerValidationGroup.class)
    private Double desiredSalary;


}
