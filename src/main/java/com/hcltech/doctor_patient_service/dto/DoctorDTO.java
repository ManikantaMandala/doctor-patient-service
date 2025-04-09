package com.hcltech.doctor_patient_service.dto;

import java.util.List;

import com.hcltech.doctor_patient_service.model.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private Long id;
    private String name;
    private String specialization;
    private List<Appointment> appointments;
}
