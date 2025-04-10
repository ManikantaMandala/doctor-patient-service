package com.hcltech.doctor_patient_service.controller;

import com.hcltech.doctor_patient_service.dto.DoctorDTO;
import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        DoctorDTO doctor = doctorService.createDoctor(doctorDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(doctor.getId())
                .toUri();

        return ResponseEntity.created(location).body(doctor);
    }
}
