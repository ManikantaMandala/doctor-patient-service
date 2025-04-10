package com.hcltech.doctor_patient_service.dao.service;

import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DoctorDAOService {
    @Autowired
    private DoctorRepo doctorRepository;

    public List<Doctor> get() {
        List<Doctor> doctors = doctorRepository.findAll();

        return doctors;
    }
}



