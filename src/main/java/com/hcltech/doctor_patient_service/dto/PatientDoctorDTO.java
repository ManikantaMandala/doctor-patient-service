package com.hcltech.doctor_patient_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDoctorDTO {
    private Long id;
    private String name;
    private String specialization;
    private Boolean isAvaiable;
}
