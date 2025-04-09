package com.hcltech.doctor_patient_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcltech.doctor_patient_service.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{
}
