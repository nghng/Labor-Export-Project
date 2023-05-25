package com.example.exportlabor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
public class Worker extends User {

    private enum Gender {
        MALE,
        FEMALE;
    }

    private static final int MAX_GENDER_VALUE = 1;
    @PrimaryKeyJoinColumn
    @Column(nullable = false, updatable = false)
    private Long workerId;

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

    public Worker(Long userId, String username, String password, String email, String name, Long workerId, Date dob, Gender gender, String skill, String education, String workExperience, Double desiredSalary) {
        super(userId, username, password, email, name);
        this.workerId = workerId;
        this.dob = dob;
        this.gender = gender;
        this.skill = skill;
        this.education = education;
        this.workExperience = workExperience;
        this.desiredSalary = desiredSalary;
    }

    public Worker(Long workerId, Date dob, Gender gender, String skill, String education, String workExperience, Double desiredSalary) {
        this.workerId = workerId;
        this.dob = dob;
        this.gender = gender;
        this.skill = skill;
        this.education = education;
        this.workExperience = workExperience;
        this.desiredSalary = desiredSalary;
    }

    public Worker() {
    }


    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public Double getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(Double desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    // The worker apply for a contract


}
