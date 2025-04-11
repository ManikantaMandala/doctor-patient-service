package com.hcltech.doctor_patient_service.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property = "appointmentId")
public class AppointmentDTO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "appointment_id")
    private Long appointmentId;

//    @Column(name = "appointment_time", nullable = false)
    private LocalDateTime time;

    private int doctorId;
    private Long patientId;

//    @ManyToOne
//    @JoinColumn(name = "fk_doctor_doc_id", nullable = false)
    //private Doctor doctor;

//    @OneToOne
//    @JoinColumn(name = "fk_patient_id", nullable = false)
    //private Patient patient;
}
