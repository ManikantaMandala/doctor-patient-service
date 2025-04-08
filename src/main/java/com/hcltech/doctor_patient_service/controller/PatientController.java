package com.hcltech.doctor_patient_service.controller;

import com.hcltech.doctor_patient_service.dto.PatientDto;
import com.hcltech.doctor_patient_service.mapper.PatientMapper;
import com.hcltech.doctor_patient_service.model.Patient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    PatientMapper patientMapper;
    public PatientController(PatientMapper patientMapper){
        this.patientMapper=patientMapper;
    }

    @PostMapping("/insert")
    public ResponseEntity<PatientDto> insert(@RequestBody PatientDto p)
    {
        PatientDto p1=patientMapper.insert1(p);
        if(p1!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(p1);
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/update")
            public ResponseEntity<PatientDto> update(@RequestBody PatientDto p){
        PatientDto p1= patientMapper.update1(p);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        }
        return ResponseEntity.internalServerError().build();
    }




}
