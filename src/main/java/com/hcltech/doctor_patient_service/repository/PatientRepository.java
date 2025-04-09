package com.hcltech.doctor_patient_service.repository;

import com.hcltech.doctor_patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("select COUNT(DISTINCT a.doctor) from Patient p"+"JOIN p.appointment a"+"WHERE p.id=:patientId")
    long countPatientsByDoctorId(long id);

}
