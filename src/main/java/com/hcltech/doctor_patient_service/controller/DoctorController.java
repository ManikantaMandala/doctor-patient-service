package com.hcltech.doctor_patient_service.controller;

import com.hcltech.doctor_patient_service.dto.PatientDoctorDTO;
import com.hcltech.doctor_patient_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<PatientDoctorDTO>> get() {
        List<PatientDoctorDTO> doctorDtos = doctorService.get();

        return ResponseEntity.ok(doctorDtos);
    }
    

}
