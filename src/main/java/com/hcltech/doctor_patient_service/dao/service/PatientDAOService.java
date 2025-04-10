package com.hcltech.doctor_patient_service.dao.service;

import org.springframework.stereotype.Service;

import com.hcltech.doctor_patient_service.model.Patient;
import com.hcltech.doctor_patient_service.repository.PatientRepo;

import java.util.Optional;

@Service
public class PatientDAOService {

    private final PatientRepo patientRepo;

    public PatientDAOService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient getAppointmentByPatientId(Long patientId) {
        Optional<Patient> optionalPatient = patientRepo.findById(patientId);
        return optionalPatient.orElse(null);
    }
}
