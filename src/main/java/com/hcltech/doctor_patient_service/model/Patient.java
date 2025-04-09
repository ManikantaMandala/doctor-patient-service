package com.hcltech.doctor_patient_service.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @Column(name = "patient_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_first_name", nullable = false, length = 35)
    private String firstName;

    @Column(name = "patient_last_name", nullable = false, length = 35)
    private String lastName;

    @Column(name = "patient_age", nullable = false)
    private int age;

    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
