package com.hcltech.doctor_patient_service.service;

import com.hcltech.doctor_patient_service.dto.PatientDTO;
import com.hcltech.doctor_patient_service.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    public List<PatientDTO> getAllPatientDetails() {

        return null;
    }


    //----------------------------------------

    public static Patient toEntity(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setAge(patientDTO.getAge());
        patient.setDoctor(patientDTO.getDoctor());
        return patient;
    }

    public static PatientDTO toDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setAge(patient.getAge());
        patientDTO.setDoctor(patient.getDoctor());
        return patientDTO;
    }

    public static List<Patient> toEntity(List<PatientDTO> patientDTO){
        return patientDTO.stream().map(b->toEntity(b)).toList();
    }

    public static List<PatientDTO> toDTO(List<Patient> patient){

        return patient.stream().map(p->toDTO(p)).toList();
    }

}
