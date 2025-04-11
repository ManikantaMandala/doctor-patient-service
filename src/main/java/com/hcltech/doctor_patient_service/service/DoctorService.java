package com.hcltech.doctor_patient_service.service;

import java.util.List;

import com.hcltech.doctor_patient_service.dao.service.DoctorDAOService;
import com.hcltech.doctor_patient_service.dao.service.AppointmentDAOService;
import com.hcltech.doctor_patient_service.dto.DoctorDTO;
import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.dto.PatientDoctorDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.ArrayList;

@Service
public class DoctorService {

    private final DoctorDAOService doctorDAOService;
    private final AppointmentDAOService appointmentDAOService;

    public DoctorService(DoctorDAOService doctorDAOService,AppointmentDAOService appointmentDAOService) {
        this.doctorDAOService = doctorDAOService;
        this.appointmentDAOService = appointmentDAOService;
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        Doctor doctor = doctorDAOService.getAppointmentById(doctorId);

        if(doctor == null) {
            // TODO: controller advice
            // TODO: custom exception
            throw new RuntimeException("pass correct doctor id");
        }

        return doctor.getAppointments();
    }


    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
       Doctor doctor = toEntity(doctorDTO);

       Doctor responseDoctor = doctorDAOService.createDoctor(doctor);

       return toDto(responseDoctor);
    }

    public Doctor toEntity(DoctorDTO doctorDTO) {
        Doctor doctor=new Doctor();

        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSpecialization(doctorDTO.getSpecialization());

        List<Appointment> appointments = null;

        if(doctorDTO.getAppointmentIds() != null) {
            appointments = getAppointmentsByAppointmentIds(doctorDTO.getAppointmentIds());
        }

        doctor.setAppointments(appointments);

        return doctor;
    }

    private List<Appointment> getAppointmentsByAppointmentIds(List<Long> appointmentIds) {
        List<Appointment> appointmentList = new ArrayList<>();

        for (Long appointmentId : appointmentIds) {
            Appointment appointment = appointmentDAOService.getAppointmentById(appointmentId);
            appointmentList.add(appointment);
        }

        return appointmentList;
    }

    public DoctorDTO toDto(Doctor doctor) {
        DoctorDTO doctorDTO=new DoctorDTO();

        System.out.println(doctor.getId());

        doctorDTO.setName(doctor.getName());
        doctorDTO.setId(doctor.getId());
        doctorDTO.setSpecialization(doctor.getSpecialization());

        List<Long> appointmentIdList = getAppointmentIdFromAppointments(doctor.getAppointments());

        doctorDTO.setAppointmentIds(appointmentIdList);

        return doctorDTO;
    }

    private List<Long> getAppointmentIdFromAppointments(List<Appointment> appointments) {
        if(appointments == null) {
            return null;
        }
        return appointments
                .stream()
                .map(appointment -> appointment.getId())
                .toList();
    }

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
