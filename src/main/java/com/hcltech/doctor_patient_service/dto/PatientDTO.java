package com.hcltech.doctor_patient_service.dto;

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
    private Integer age;
    private Gender gender;
    private AppointmentDTO currentAppointmentDTO;
}
