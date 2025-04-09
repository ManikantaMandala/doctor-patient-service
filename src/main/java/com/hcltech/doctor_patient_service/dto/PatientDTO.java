package com.hcltech.doctor_patient_service.dto;

import com.hcltech.doctor_patient_service.model.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private Doctor doctor;
}
