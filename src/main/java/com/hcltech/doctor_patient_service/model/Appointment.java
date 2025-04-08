package com.hcltech.doctor_patient_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    private int id;
   private LocalDateTime datetime;
   @ManyToOne
   @JoinColumn(name="doctor_id",referencedColumnName ="id")
   private Doctor doctor;

    
}
