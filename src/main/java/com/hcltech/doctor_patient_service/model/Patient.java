package com.hcltech.doctor_patient_service.model;

import com.hcltech.doctor_patient_service.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseModel {
    @Column(name = "patient_name")
    private String name;

    @Column(name = "patient_age")
    private int age;

    @Column(name = "patient_gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    // @JoinColumn(name = "doctor_id", nullable = true)
    private Doctor doctor;
}
