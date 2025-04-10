package com.hcltech.doctor_patient_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.service.DoctorService;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    
    @GetMapping
    public ResponseEntity<List<Appointment>> viewAppointmentsByDoctorId(@RequestParam Long doctorId) {
        List<Appointment> appointments = doctorService.getAppointmentsByDoctorId(doctorId);

        return ResponseEntity.ok(appointments);
    }

}
