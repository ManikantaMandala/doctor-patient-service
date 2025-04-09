package com.hcltech.doctor_patient_service.model;

import com.hcltech.doctor_patient_service.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseModel {
    @Column(name = "patient_first_name", nullable = false, length = 35)
    private String firstName;

    @Column(name = "patient_last_name", nullable = false, length = 35)
    private String lastName;

    @Column(name = "patient_age", nullable = false)
    private int age;

    @Column(name = "patient_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = true)
    private Doctor doctor;

    @OneToOne
    private Appointment currentAppointment;
}
