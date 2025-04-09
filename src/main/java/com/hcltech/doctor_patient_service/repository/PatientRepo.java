package com.hcltech.doctor_patient_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcltech.doctor_patient_service.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long>{
}
