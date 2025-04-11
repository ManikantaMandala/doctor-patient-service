package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.model.Patient;
import com.hcltech.doctor_patient_service.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcltech.doctor_patient_service.model.Patient;
import com.hcltech.doctor_patient_service.repository.PatientRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PatientDAOService {

    @Autowired
    private PatientRepo patientRepo;

    public Patient getAppointmentByPatientId(Long patientId) {
        Optional<Patient> optionalPatient = patientRepo.findById(patientId);
        return optionalPatient.orElse(null);
    }

    public Patient getPatientDetails(Long id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
    }

    public List<Patient> getAllPatientDetails() {
        return patientRepo.findAll();
    }

    public Patient insertPatientDetails(Patient patient) throws IllegalArgumentException {
        return patientRepo.save(patient);
    }

    public Patient updatePatientDetails(Patient patient) {
        Patient response = patientRepo.findById(patient.getId()).orElse(null);
        if(response==null) return null;
        return patientRepo.save(patient);
    }

}
