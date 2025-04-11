package com.hcltech.doctor_patient_service.service;

import com.hcltech.doctor_patient_service.dao.service.AppointmentDAOService;
import com.hcltech.doctor_patient_service.dao.service.PatientDAOService;
import com.hcltech.doctor_patient_service.dto.AppointmentDTO;
import com.hcltech.doctor_patient_service.dto.PatientDTO;
import com.hcltech.doctor_patient_service.model.Appointment;
import com.hcltech.doctor_patient_service.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private AppointmentService appointmentService;
    private final PatientDAOService patientDAOService;
    private final AppointmentDAOService appointmentDAOService;

    public PatientService(PatientDAOService patientDAOService, AppointmentDAOService appointmentDAOService) {
        this.patientDAOService = patientDAOService;
        this.appointmentDAOService = appointmentDAOService;
    }

    public PatientDTO insertPatientDetails(PatientDTO patientDto)
    {
        Patient patient=toEntity(patientDto);
        Patient response= patientDAOService.insertPatientDetails(patient);
        return toDTO(response);
    }

    public PatientDTO updatePatientDetails(PatientDTO patientDTO){
        Patient patient=toEntity(patientDTO);
        Patient response= patientDAOService.updatePatientDetails(patient);
        return toDTO(response);
    }

    public PatientDTO getPatientDetails(Long id) {
        Patient patient = patientDAOService.getPatientDetails(id);
        Appointment appt = patient.getCurrentAppointment();
        Long doctorId = (appt != null) ? appt.getDoctor().getId() : 0;
        return toDTO(patient);
    }

    public List<PatientDTO> getAllPatientDetails() {
        List<Patient> patient = patientDAOService.getAllPatientDetails();
        return toDTO(patient);
    }

//    private PatientDTO mapToPatientDTO(Patient patient, int doctorId) {
//        return new PatientDTO(patient.getId(), patient.getFirstName(), patient.getLastName(),
//                patient.getAge(), patient.getGender(), patient.getPhoneNumber(), doctorId);
//    }

    public Patient toEntity(PatientDTO patientDTO){
        Patient patient = new Patient();

        patient.setId(patientDTO.getId());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setGender(patientDTO.getGender());
        patient.setAge(patientDTO.getAge());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());

        Long appointmentId = patientDTO.getAppointmentId();

        Appointment appointment = appointmentDAOService.getAppointmentById(appointmentId);
        patient.setCurrentAppointment(appointment);

        return patient;
    }

    public PatientDTO toDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId(patient.getId());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setName(patient.getFirstName()+" "+patient.getLastName());
        patientDTO.setAge(patient.getAge());
        patientDTO.setGender(patient.getGender());
        patientDTO.setPhoneNumber(patient.getPhoneNumber());
        if(patient.getCurrentAppointment() == null) {
            patientDTO.setAppointmentId(null);
        }else {

            patientDTO.setAppointmentId(patient.getCurrentAppointment().getId());
        }

        return patientDTO;
    }

    public List<Patient> toEntity(List<PatientDTO> patientDTO){
        return patientDTO.stream().map(b->toEntity(b)).toList();
    }

    public List<PatientDTO> toDTO(List<Patient> patient){
        return patient.stream().map(p->toDTO(p)).toList();
    }


    public AppointmentDTO getAppointmentByPatientId(Long patientId) {
        Patient patient = patientDAOService.getAppointmentByPatientId(patientId);

        if(patient == null) {
            throw new IllegalArgumentException("give me patientId not gembo bombo");
        }

        Appointment appointment = patient.getCurrentAppointment();
        return appointmentService.toDTO(appointment);
    }

}
