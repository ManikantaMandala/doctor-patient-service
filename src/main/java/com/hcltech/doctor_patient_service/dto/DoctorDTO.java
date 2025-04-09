package com.hcltech.doctor_patient_service.dto;

import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DoctorDTO {

    private Long id;

    private String name;

    private String specialization;

    private List<Patient> patients;

    private List<Appointment> appointments;
}
