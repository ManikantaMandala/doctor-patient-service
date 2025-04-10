package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.dto.AppointmentDTO;
import org.springframework.stereotype.Service;

import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.repository.AppointmentRepo;

@Service
public class AppointmentDAOService {

    private AppointmentRepo appointmentRepo;

    public AppointmentDAOService(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepo.getReferenceById(appointmentId);
    }

    public void deleteAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepo.getReferenceById(appointmentId);

        if(appointment == null) {
            // TODO: add controller advice
            // create custom exception

            throw new IllegalArgumentException("appointment does not exist");
        }

        appointment.getDoctor().getAppointments().remove(appointment);
        appointment.getPatient().setCurrentAppointment(null);

        appointmentRepo.deleteById(appointmentId);
    }

    public AppointmentDTO toDTO(Appointment appointment) {
        return null;
    }
}
