package com.hcltech.doctor_patient_service.controller;

import com.hcltech.doctor_patient_service.dto.AppointmentDTO;
import com.hcltech.doctor_patient_service.dto.PatientDTO;
import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @PostMapping("/insert")
    public ResponseEntity<PatientDTO> insertPatientDetails(@RequestBody PatientDTO patientDto)
    {
        PatientDTO response=patientService.insertPatientDetails(patientDto);
        if(response!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDTO> update(@RequestBody PatientDTO p){
        PatientDTO p1= patientService.update1(p);
        if(p1!=null){
            return ResponseEntity.ok(p1);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping(path = "/getDetailsOfPatients")
    public ResponseEntity<List<PatientDTO>> getAllPatientDetails(){
        List<PatientDTO> response = patientService.getAllPatientDetails();
        if(response.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<AppointmentDTO> viewAppointmentByPatientId(@RequestParam Long patientId) {
        AppointmentDTO appointmentDTO = patientService.getAppointmentByPatientId(patientId);

        return ResponseEntity.ok(appointmentDTO);
    }

}
