package com.hcltech.doctor_patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcltech.doctor_patient_service.dao.service.AppointmentDAOService;
import com.hcltech.doctor_patient_service.dto.AppointmentDTO;
import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.repository.AppointmentRepo;

@Service
public class AppointmentService {

    private AppointmentDAOService appointmentDAOService;

    public AppointmentService(AppointmentDAOService appointmentDAOService) {
        this.appointmentDAOService = appointmentDAOService;
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

    public void deleteAppointment(Long appointmentId) throws IllegalArgumentException {
        appointmentDAOService.deleteAppointmentById(appointmentId);
    }

}
