package com.hcltech.doctor_patient_service.service;

import java.util.List;
import java.util.Optional;

import com.hcltech.doctor_patient_service.dao.service.DoctorDAOService;
import org.springframework.stereotype.Service;

import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.repository.DoctorRepo;

@Service
public class DoctorService {

    private DoctorDAOService doctorDAOService;

    public DoctorService(DoctorDAOService doctorDAOService) {
        this.doctorDAOService = doctorDAOService;
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        Doctor doctor = doctorDAOService.getAppointmentById(doctorId);

        if(doctor == null) {
            // TODO: controller advice
            // TODO: custom exception
            throw new RuntimeException("pass correct doctor id");
        }

        return doctor.getAppointments();
    }
}
