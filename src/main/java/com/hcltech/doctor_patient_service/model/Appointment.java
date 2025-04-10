package com.hcltech.doctor_patient_service.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
// TODO: Ask Why this is required?
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "Id")
public class Appointment extends BaseModel {

//    @NotNull(message = "Appointment time must not be null")
//    @Future(message = "Appointment time must be in the future")

    @Column(name = "appointment_time", nullable = false)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "fk_appointment_doctor", referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "fk_appointment_patient", referencedColumnName = "id", nullable = false)
    private Patient patient;
}
