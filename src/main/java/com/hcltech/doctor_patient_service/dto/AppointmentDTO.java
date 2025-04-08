package com.hcltech.doctor_patient_service.dto;

import com.hcltech.doctor_patient_service.model.Doctor;
import com.hcltech.doctor_patient_service.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "appointment_id")
    private Long appointmentId;

//    @Column(name = "appointment_time", nullable = false)
    private LocalDateTime time;

//    @ManyToOne
//    @JoinColumn(name = "fk_doctor_doc_id", nullable = false)
    private Doctor doctor;

//    @OneToOne
//    @JoinColumn(name = "fk_patient_id", nullable = false)
    private Patient patient;
}
