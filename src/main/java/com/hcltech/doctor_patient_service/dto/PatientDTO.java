package com.hcltech.doctor_patient_service.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.hcltech.doctor_patient_service.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String name;
    private Integer age;
    private Gender gender;
    private String phoneNumber;
    private Long appointmentId;
}
