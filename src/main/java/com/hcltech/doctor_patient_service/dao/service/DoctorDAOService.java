package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.repository.DoctorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Doctor> get() {
        return doctorRepo.findAll();
    }

    public Doctor getDoctorById(Long doctorId) {
        return doctorRepo.findById(doctorId).orElse(null);
    }

    public Doctor updateDoctor(Doctor doctor) {
        Doctor savedDoctor = null;
        try {
            savedDoctor = doctorRepo.save(doctor);
        } catch (Exception e) {
            // TODO: controller advice
            // TODO: custom exception
            throw new RuntimeException(e);
        } finally {
            // TODO: Ask Saravana or ChatGPT
            return savedDoctor;
        }

    }

}
