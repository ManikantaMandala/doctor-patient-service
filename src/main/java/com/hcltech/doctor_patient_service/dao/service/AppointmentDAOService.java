package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentDAOService {
    @Autowired
    AppointmentRepo appointmentRepo;

    public Appointment getAppointmentById(Long id) {
        if(id == null) {
            return null;
        }
        return appointmentRepo.findById(id).orElse(null);
    }
}
