package com.example.exportlabor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "employerId", referencedColumnName = "userId")
public class Employer extends User {

    @ManyToOne
    @JoinColumn( name = "agencyId")
    private Agency agency;





}
