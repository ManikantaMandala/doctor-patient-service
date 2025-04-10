package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorDAOService {
    DoctorRepo doctorRepo;

    public DoctorDAOService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }
}
