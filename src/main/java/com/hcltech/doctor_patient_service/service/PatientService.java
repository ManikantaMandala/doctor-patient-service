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

    public Patient toEntity(PatientDTO patientDTO){
        Patient patient = new Patient();


        return patient;
    }
}
