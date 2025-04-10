package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.model.Patient;
import com.hcltech.doctor_patient_service.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientDAOService {
    @Autowired
    PatientRepo patientRepo;
    public Patient insertPatient(Patient patient) {

        return patientRepo.save(patient);

    }

    public Patient updatePatient(Patient patient) {
        Patient response = patientRepo.findById(patient.getId()).orElse(null);

        /*long res = patientRepository.countPatientsByDoctorId(p.getId());
        if(res<4 && p1!=null)
            return patientRepository.save(p);*/
        if(response==null)
        return null;
        return patientRepo.save(patient);

    }
}
