package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.repository.DoctorRepo;
import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorDAOService {

    private final DoctorRepo doctorRepo;

    public DoctorDAOService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor getAppointmentById(Long doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(doctorId);

        return optionalDoctor.orElse(null);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }
}
