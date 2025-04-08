package com.hcltech.doctor_patient_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.UUID;
@Entity
public class Patient {

    @Id
    UUID id;
    String name;
    int age;
   @OneToOne
    @JoinColumn(name="d_id",referencedColumnName ="id")
    Doctor doctor;

}
