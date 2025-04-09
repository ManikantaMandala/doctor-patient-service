package com.hcltech.doctor_patient_service.service;

import com.hcltech.doctor_patient_service.model.Patient;
import com.hcltech.doctor_patient_service.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient insert2(Patient p) {
        long id1 = p.getId();
        long res = patientRepository.countPatientsByDoctorId(id1);
        if (res < 4) {
            return patientRepository.save(p);
        }
        return null;
    }

    public Patient update2(Patient p) {
        Patient p1 = patientRepository.findById(p.getId()).orElse(null);
        if (p1 == null) {
            return null;
        }
        return patientRepository.save(p);

    }
}