package com.hcltech.doctor_patient_service.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcltech.doctor_patient_service.service.AppointmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointmentById(@PathVariable @Valid Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);

        return ResponseEntity.noContent().build();
    }

}
