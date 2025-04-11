package com.hcltech.doctor_patient_service.controller;

import com.hcltech.doctor_patient_service.dto.DoctorDTO;
import com.hcltech.doctor_patient_service.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import com.hcltech.doctor_patient_service.dto.PatientDoctorDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcltech.doctor_patient_service.model.Appointment;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientDoctorDTO>> get() {
        List<PatientDoctorDTO> doctorDtos = doctorService.get();

        return ResponseEntity.ok(doctorDtos);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> viewAppointmentsByDoctorId(@RequestParam @Valid Long doctorId) {
        List<Appointment> appointments = doctorService.getAppointmentsByDoctorId(doctorId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorDetails(@PathVariable @Valid Long id) {
        DoctorDTO doctorDTO = doctorService.getDoctorDetailsByDoctorId(id);
        return ResponseEntity.ok(doctorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDoctorById(@PathVariable @Valid Long id, @RequestBody @Valid DoctorDTO doctorDTO) {
        doctorService.updateDoctorById(id, doctorDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        DoctorDTO doctor = doctorService.createDoctor(doctorDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(doctor.getId())
                .toUri();

        return ResponseEntity.created(location).body(doctor);
    }

}
