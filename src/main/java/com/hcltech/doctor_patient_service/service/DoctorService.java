package com.hcltech.doctor_patient_service.service;

import com.hcltech.doctor_patient_service.dao.service.DoctorDAOService;
import com.hcltech.doctor_patient_service.dto.PatientDoctorDTO;
import com.hcltech.doctor_patient_service.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private DoctorDAOService doctorDAOService;

    public List<PatientDoctorDTO> get() {
        List<PatientDoctorDTO> patientDoctorDTOList = doctorDAOService.get().stream().map(this::toPatientDoctorDto).collect(Collectors.toList());
        return patientDoctorDTOList;
    }

    public PatientDoctorDTO toPatientDoctorDto(Doctor doctor) {
        PatientDoctorDTO patientDoctorDTO = new PatientDoctorDTO();
        patientDoctorDTO.setId(doctor.getId());
        patientDoctorDTO.setName(doctor.getName());
        patientDoctorDTO.setSpecialization(doctor.getSpecialization());
        patientDoctorDTO.setIsAvaiable(doctor.getAppointments().size() < 4);

        return patientDoctorDTO;
    }


}
