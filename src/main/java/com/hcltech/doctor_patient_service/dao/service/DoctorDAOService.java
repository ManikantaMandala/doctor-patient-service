package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.repository.DoctorRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorDAOService {

    private DoctorRepo doctorRepo;

    public DoctorDAOService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor getAppointmentById(Long doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(doctorId);

        return optionalDoctor.orElse(null);
    }
}
