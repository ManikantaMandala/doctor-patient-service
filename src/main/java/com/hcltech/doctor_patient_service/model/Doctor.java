package com.hcltech.doctor_patient_service.model;

import java.util.List;

import org.hibernate.annotations.BatchSize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends BaseModel {
    @Column(name = "doctor_name", nullable = false)
    private String name;

    @Column(name = "doctor_specialization", nullable = false)
    private String specialization;

    @OneToMany(mappedBy = "doctor")
    @JoinColumn(name="patient_id_f_key", referencedColumnName = "id")
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    @JoinColumn(name="appointment_id_f_key", referencedColumnName = "id")
    private List<Appointment> appointments;
}
