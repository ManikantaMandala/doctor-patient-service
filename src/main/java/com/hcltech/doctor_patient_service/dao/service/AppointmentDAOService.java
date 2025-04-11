package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.dto.AppointmentDTO;
import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.repository.AppointmentRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentDAOService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        if(id == null) {
            return null;
        }
        return appointmentRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Appointment doesn't found with appointment ID"+id));
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

    public List<Appointment> getAllAppointments() {
         return appointmentRepo.findAll();
    }

}
