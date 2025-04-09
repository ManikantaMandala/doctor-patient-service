package com.hcltech.doctor_patient_service.service;

import org.springframework.stereotype.Service;

import com.hcltech.doctor_patient_service.dto.AppointmentDTO;
import com.hcltech.doctor_patient_service.model.Appointment;

@Service
public class AppointmentService {

    public AppointmentService() {
        // empty constructor
    }

    public static AppointmentDTO toDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setAppointmentId(appointment.getId());
        appointmentDTO.setDoctor(appointment.getDoctor());
        appointmentDTO.setPatient(appointment.getPatient());
        appointmentDTO.setTime(appointment.getTime());

        return appointmentDTO;
    }

    public static Appointment toEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();

        appointment.setId(appointmentDTO.getAppointmentId());
        appointment.setDoctor(appointmentDTO.getDoctor());
        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setTime(appointmentDTO.getTime());

        return appointment;
    }
}
