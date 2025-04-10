package com.hcltech.doctor_patient_service.model;

import com.hcltech.doctor_patient_service.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
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

    @Column(name = "patient_phone_number", nullable = false)
    private String phoneNumber;

    @OneToOne(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Appointment currentAppointment;
}
