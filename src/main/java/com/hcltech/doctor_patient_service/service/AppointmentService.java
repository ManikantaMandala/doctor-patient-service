package com.hcltech.doctor_patient_service.service;

import java.util.List;

import com.hcltech.doctor_patient_service.dto.PatientDTO;
import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.model.Patient;
import com.hcltech.doctor_patient_service.repository.DoctorRepo;
import com.hcltech.doctor_patient_service.repository.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcltech.doctor_patient_service.dao.service.AppointmentDAOService;
import com.hcltech.doctor_patient_service.dto.AppointmentDTO;
import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.repository.AppointmentRepo;

@Service
public class AppointmentService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    private AppointmentDAOService appointmentDAOService;

    public AppointmentService(AppointmentDAOService appointmentDAOService) {
        this.appointmentDAOService = appointmentDAOService;
    }

    public AppointmentDTO bookAppointment(AppointmentDTO appointmentDTO) {
        Doctor doctor = doctorRepo.findById((long) appointmentDTO.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID"));

        if (doctor.getAppointments() != null && doctor.getAppointments().size() >= 4) {
            throw new IllegalStateException("Doctor already has 4 appointments");
        }

        Patient patient = patientRepo.findById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));

        Appointment appointment = new Appointment();
        appointment.setTime(appointmentDTO.getTime());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        Appointment savedAppointment = appointmentDAOService.bookAppointment(appointment);

        // ⬇️ Added: update patient's currentAppointment reference
        patient.setCurrentAppointment(savedAppointment);
        patientRepo.save(patient);
        return mapToAppointmentDTO(savedAppointment);
    }


    public void deleteAppointment(Long appointmentId) throws IllegalArgumentException {
        appointmentDAOService.deleteAppointmentById(appointmentId);
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentDAOService.getAllAppointments();
        return toDTO(appointments);
    }

    public List<AppointmentDTO> toDTO(List<Appointment> result){
        return result.stream().map(p->toDTO(p)).toList();
    }

    public AppointmentDTO toDTO(Appointment appointment){
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setAppointmentId(appointment.getId());
        appointmentDTO.setTime(appointment.getTime());
        appointmentDTO.setDoctorId(Math.toIntExact(appointment.getDoctor().getId()));
        appointmentDTO.setPatientId(appointment.getPatient().getId());
        return appointmentDTO;
    }


    private AppointmentDTO mapToAppointmentDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getId(),
                appointment.getTime(),
                Math.toIntExact(appointment.getDoctor().getId()),
                appointment.getPatient().getId()
        );
    }
    /*
    public static AppointmentDTO toDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setAppointmentId(appointment.getId());
        appointmentDTO.setDoctor(appointment.getDoctor());
        appointmentDTO.setPatient(appointment.getPatient());
        appointmentDTO.setTime(appointment.getTime());

        return appointmentDTO;
    }

    public static Appointment toEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();

        appointment.setId(appointmentDTO.getAppointmentId());
        appointment.setDoctor(appointmentDTO.getDoctor());
        appointment.setPatient(appointmentDTO.getPatient());
        appointment.setTime(appointmentDTO.getTime());

        return appointment;
    }
*/

}
