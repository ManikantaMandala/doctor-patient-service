package com.hcltech.doctor_patient_service.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @Column(name = "doctor_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_name", nullable = false, length = 35)
    private String name;

    @Column(name = "doctor_specialization", nullable = false, length = 35)
    private String specialization;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name="patient_id_f_key", referencedColumnName = "id")
    private List<Patient> patients;

    @OneToMany
//    @JoinColumn(name="appointment_id_f_key")
    private List<Appointment> appointments;
}
