package com.hcltech.doctor_patient_service.dto;

public class PatientDto {
    private Long id;
    private int age;
    private String firstname;
    private String lastname;
    private String fullname;
    private int appointment;

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public int getAppointment() {
        return appointment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAppointment(int appointment) {
        this.appointment = appointment;
    }
}
